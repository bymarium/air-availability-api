package com.airsofka.flight.application.flight.assignRoute;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class AssignRouteUseCase implements ICommandUseCase<AssignRouteRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    public AssignRouteUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(AssignRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.assingRoute(request.getRouteId());
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return mapToResponse(flight);
                });
    }
}
