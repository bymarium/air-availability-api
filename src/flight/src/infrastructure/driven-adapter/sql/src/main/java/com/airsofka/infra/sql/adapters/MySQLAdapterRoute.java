package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.infra.sql.entities.RouteEntity;
import com.airsofka.infra.sql.repositories.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


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
    public void updateRoute(Long id, String origin, Integer duration, String destination) {
        RouteEntity routeFound = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Route not found"));
        routeFound.setOrigin(origin);
        routeFound.setDuration(duration);
        routeFound.setDestination(destination);
        routeRepository.save(routeFound);

    }
    @Override
    public Mono<Route> findById(Long id) {
        return Mono.fromCallable(() -> {
            RouteEntity route = routeRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Route not found"));
            return RouteAdapter.toDomain(route);
        });
    }

    @Override
    public void removeRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public Mono<Route> findByAggregateId(String aggregateId) {
        return Mono.fromCallable(() -> {
            RouteEntity route = routeRepository.findByAggregateId(aggregateId)
              .orElseThrow(() -> new RuntimeException("Route not found"));
            return RouteAdapter.toDomain(route);
        });
    }
}