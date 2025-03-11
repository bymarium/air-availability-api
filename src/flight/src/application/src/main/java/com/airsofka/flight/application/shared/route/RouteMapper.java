package com.airsofka.flight.application.shared.route;

import com.airsofka.flight.domain.route.Route;


public class RouteMapper {
    public static RouteResponse mapToResponse(Route route) {
        return new RouteResponse(
                route.getIdentity().getValue(),
                route.getOrigin().getValue(),
                route.getDuration().getValue(),
                route.getDestination().getValue()
        );
    }
}