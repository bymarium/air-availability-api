package com.airsofka.flight.domain.route.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RouteModified extends DomainEvent {

    private String routeId;
    private String origin;
    private Integer duration;
    private String destination;

    public RouteModified(String routeId, String origin, Integer duration, String destination) {
        super(EventsEnum.MODIFIED_ROUTE.name());
        this.routeId = routeId;
        this.origin = origin;
        this.duration = duration;
        this.destination = destination;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}