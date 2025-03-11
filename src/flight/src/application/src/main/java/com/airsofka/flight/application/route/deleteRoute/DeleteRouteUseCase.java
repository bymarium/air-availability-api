package com.airsofka.flight.application.route.deleteRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteMapper;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DeleteRouteUseCase implements ICommandUseCase<DeleteRouteRequest, Mono<RouteResponse>> {
    private final IEventsRepositoryPort repository;
    private final IRouteRepositoryPort routeRepositoryPort;

    public DeleteRouteUseCase(IEventsRepositoryPort repository, IRouteRepositoryPort routeRepositoryPort) {
        this.repository = repository;
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public Mono<RouteResponse> execute(DeleteRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Route route = Route.from(request.getAggregateId(), events);
                    route.removeRoute(request.getAggregateId());
                    route.getUncommittedEvents().forEach(repository::save);
                    route.markEventsAsCommitted();
                    routeRepositoryPort.removeRoute(request.getAggregateId());
                    return RouteMapper.mapToResponse(route);
                });
    }
}