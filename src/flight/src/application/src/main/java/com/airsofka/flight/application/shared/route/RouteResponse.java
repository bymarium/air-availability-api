package com.airsofka.flight.application.shared.route;

import reactor.core.publisher.Mono;

public class RouteResponse {
    private String aggregateId;
    private String origin;
    private Integer duration;
    private String destination;

    public RouteResponse(String aggregateId, String origin, Integer duration, String destination) {
        this.aggregateId = aggregateId;
        this.origin = origin;
        this.duration = duration;
        this.destination = destination;
    }

    public String getRouteId() {
        return aggregateId;
    }

    public void setRouteId(String routeId) {
        this.aggregateId = routeId;
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