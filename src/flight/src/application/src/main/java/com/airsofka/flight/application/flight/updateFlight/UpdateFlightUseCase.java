package com.airsofka.flight.application.flight.updateFlight;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class UpdateFlightUseCase implements ICommandUseCase<UpdateFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;

    public UpdateFlightUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(UpdateFlightRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.updateFlight(request.getFlightNumber(), request.getRouteId(), request.getSeatId(), request.getDepartureTime(), request.getArrivalTime());
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return mapToResponse(flight);
                });
    }
}
