package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteMapper;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DisplayRouteUseCase implements ICommandUseCase<DisplayRouteRequest, Mono<RouteResponse>> {
    private final IEventsRepositoryPort repository;
    private final IRouteRepositoryPort routeRepositoryPort;

    public DisplayRouteUseCase(IEventsRepositoryPort repository, IRouteRepositoryPort routeRepositoryPort) {
        this.repository = repository;
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public Mono<RouteResponse> execute(DisplayRouteRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .flatMap(events -> {
                    Route route = Route.from(request.getAggregateId(), events);
                    route.getUncommittedEvents().forEach(repository::save);
                    route.markEventsAsCommitted();
                    return routeRepositoryPort.findById(request.getId())
                            .map(RouteMapper::mapToResponse);
                });
    }
}