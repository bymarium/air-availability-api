package com.airsofka.flight.application.shared.ports;

import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IRouteRepositoryPort {
    void saveRoute(Route route);

    void updateRoute(Long id, String origin, Integer duration, String destination);

    Mono<Route> findById(Long id);

    void removeRoute(Long id);
}
