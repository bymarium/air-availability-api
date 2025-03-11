package com.airsofka.flight.application.flight.updateFlight;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class UpdateFlightUseCase implements ICommandUseCase<UpdateFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepository;

    public UpdateFlightUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepository) {

        this.repository = repository;
        this.flightRepository = flightRepository;
    }

    @Override
    public Mono<FlightResponse> execute(UpdateFlightRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    System.out.println(request.getPrice());
                    flight.updateFlight(request.getFlightNumber(), request.getRouteId(), request.getSeatId(), request.getDepartureTime(), request.getArrivalTime(),request.getPrice());
                    flightRepository.updateFlight(flight);
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return mapToResponse(flight);
                });
    }
}
