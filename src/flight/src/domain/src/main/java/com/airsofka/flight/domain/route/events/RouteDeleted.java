package com.airsofka.flight.domain.route.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RouteDeleted extends DomainEvent {
    private String routeId;

    public RouteDeleted(String routeId) {
        super(EventsEnum.DELETED_ROUTE.name());
        this.routeId = routeId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

}