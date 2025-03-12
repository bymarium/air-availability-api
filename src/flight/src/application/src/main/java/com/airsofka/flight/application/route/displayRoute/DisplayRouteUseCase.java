package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteMapper;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DisplayRouteUseCase implements ICommandUseCase<DisplayRouteRequest, RouteResponse> {
    private final IRouteRepositoryPort routeRepositoryPort;

    public DisplayRouteUseCase(IRouteRepositoryPort routeRepositoryPort) {
        this.routeRepositoryPort = routeRepositoryPort;
    }

    @Override
    public RouteResponse execute(DisplayRouteRequest request) {
        return routeRepositoryPort.findById(request.getAggregateId());
    }
}