package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteMapper;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DisplayRouteUseCase implements ICommandUseCase<DisplayRouteRequest, Mono<RouteResponse>> {
    private final IEventsRepositoryPort repository;

    public DisplayRouteUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<RouteResponse> execute(DisplayRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Route route = Route.from(request.getAggregateId(), events);
                    return RouteMapper.mapToResponse(route);
                });
    }
}