package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.infra.sql.entities.RouteEntity;
import com.airsofka.infra.sql.repositories.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MySQLAdapterRoute implements IRouteRepositoryPort {

    @Autowired
    private IRouteRepository routeRepository;

    @Autowired
    private RouteAdapter routeAdapter;

    public MySQLAdapterRoute(IRouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void saveRoute(Route route) {
        RouteEntity routeEntity = RouteAdapter.toEntity(route);
        routeRepository.save(routeEntity);
    }

    @Override
    public void updateRoute(Route route) {
        RouteEntity routeFound = routeRepository.findById(Long.parseLong(route.getIdentity().getValue()))
                .orElseThrow(() -> new RuntimeException("Route not found"));
        routeFound.setOrigin(route.getOrigin().getValue());
        routeFound.setDuration(route.getDuration().getValue());
        routeFound.setDestination(route.getDestination().getValue());
        routeRepository.save(routeFound);
    }

    @Override
    public RouteResponse findById(String aggregateId) {
        RouteEntity route = routeRepository.findById(Long.parseLong(aggregateId))
                .orElseThrow(() -> new RuntimeException("Route not found"));
        return RouteAdapter.toResponse(route);
    }

    @Override
    public void removeRoute(Long id) {
        routeRepository.deleteById(id);
    }
}