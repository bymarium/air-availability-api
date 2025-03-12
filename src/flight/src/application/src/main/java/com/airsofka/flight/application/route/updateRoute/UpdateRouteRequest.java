package com.airsofka.flight.application.route.updateRoute;

import com.airsofka.shared.application.Request;

public class UpdateRouteRequest extends Request {

    private String origin;
    private Integer duration;
    private String destination;

    public UpdateRouteRequest(String aggregateId, String origin, Integer duration, String destination) {
        super(aggregateId);
        this.origin = origin;
        this.duration = duration;
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDestination() {
        return destination;
    }
}
