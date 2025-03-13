package com.airsofka.flight.application.flight.removeFlight;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class RemoveFlightUseCase implements ICommandUseCase<RemoveFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepository;

    public RemoveFlightUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepository) {
        this.flightRepository = flightRepository;
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(RemoveFlightRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.removeFlight(request.getAggregateId());
                    flightRepository.removeFlight(request.getAggregateId());
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return mapToResponse(flight);
                });
    }
}
