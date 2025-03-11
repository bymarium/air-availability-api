package com.airsofka.flight.application.shared.ports;

import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;

import java.util.List;

public interface IRouteRepositoryPort {
    void saveRoute(Route route);

    void updateFlight(Route route);

    RouteResponse findById(String aggregateId);

    void removeRoute(String aggregateId);
}
