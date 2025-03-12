package com.airsofka.flight.application.shared.route;

public class RouteResponse {
    private String origin;
    private Integer duration;
    private String destination;

    public RouteResponse(String routeId, String origin, Integer duration, String destination) {
        this.origin = origin;
        this.duration = duration;
        this.destination = destination;
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