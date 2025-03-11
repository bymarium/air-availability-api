package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DisplayRouteUseCase implements ICommandUseCase<DisplayRouteRequest, Mono<RouteResponse>> {
    private final IRouteRepositoryPort routeRepositoryPort;

    public DisplayRouteUseCase(IRouteRepositoryPort routeRepositoryPort) {
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public Mono<RouteResponse> execute(DisplayRouteRequest request) {
        return Mono.just(routeRepositoryPort.findById(request.getAggregateId()));
    }
}