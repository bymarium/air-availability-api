package com.airsofka.flight.application.route.updateRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteMapper;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class UpdateRouteUseCase implements ICommandUseCase<UpdateRouteRequest, Mono<RouteResponse>> {
    private final IEventsRepositoryPort repository;
    private final IRouteRepositoryPort routeRepositoryPort;

    public UpdateRouteUseCase(IEventsRepositoryPort repository, IRouteRepositoryPort routeRepositoryPort) {
        this.repository = repository;
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public Mono<RouteResponse> execute(UpdateRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Route route = Route.from(request.getAggregateId(), events);
                    route.updateRoute(request.getOrigin(), request.getDuration(), request.getDestination());
                    route.getUncommittedEvents().forEach(repository::save);
                    route.markEventsAsCommitted();
                    routeRepositoryPort.updateRoute(request.getId(), request.getOrigin(), request.getDuration(), request.getDestination());
                    return RouteMapper.mapToResponse(route);
                });
    }
}