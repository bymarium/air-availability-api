package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RouteChanged extends DomainEvent {
    private String flightId;
    private String routeId;

    public RouteChanged(String flightId, String routeId) {
        super(EventsEnum.CHANGED_ROUTE.name());
        this.flightId = flightId;
        this.routeId = routeId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
