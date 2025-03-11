package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.infra.sql.entities.RouteEntity;
import org.springframework.stereotype.Component;

@Component
public class RouteAdapter {

    public static RouteEntity toEntity(Route route) {
        RouteEntity entity = new RouteEntity();
        entity.setAggregateId(route.getIdentity().getValue());
        entity.setOrigin(route.getOrigin().getValue());
        entity.setDuration(route.getDuration().getValue());
        entity.setDestination(route.getDestination().getValue());
        return entity;
    }

    public static Route toDomain(RouteEntity entity) {
        Route route = new Route(
                entity.getOrigin(),
                entity.getDuration(),
                entity.getDestination()
        );
        return route;
    }

    public static RouteResponse toResponse(RouteEntity entity) {
        return new RouteResponse(
                entity.getId().toString(),
                entity.getOrigin(),
                entity.getDuration(),
                entity.getDestination()
        );
    }
}