package com.airsofka.flight.application.flight.changeRoute;

import com.airsofka.flight.application.shared.flight.FlightMapper;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ChangeRouteUseCase implements ICommandUseCase<ChangeRouteRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepositoryPort;
    public ChangeRouteUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepositoryPort) {
        this.flightRepositoryPort = flightRepositoryPort;
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(ChangeRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.changeRoute(request.getRouteId());
                    flightRepositoryPort.changeRoute(flight);
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return FlightMapper.mapToResponse(flight);
                });
    }

}
