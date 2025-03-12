package com.airsofka.flight.application.route.listRoutes;

import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;

import java.util.List;

public class ListRoutesUseCase {
    private final IRouteRepositoryPort repository;
    public ListRoutesUseCase(IRouteRepositoryPort repository) {
        this.repository = repository;
    }

    public List<RouteResponse> execute() {
        return repository.findAll();
    }
}