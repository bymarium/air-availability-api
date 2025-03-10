package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class AssignedRoute extends DomainEvent {
    private String routeId;

    public AssignedRoute(String route) {
        super(EventsEnum.ASSIGNED_ROUTE.name());
        this.routeId = route;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
