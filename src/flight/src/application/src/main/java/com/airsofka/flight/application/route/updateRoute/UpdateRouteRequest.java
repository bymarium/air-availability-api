package com.airsofka.flight.application.route.updateRoute;

import com.airsofka.shared.application.Request;

public class UpdateRouteRequest extends Request {

    private Long id;
    private String origin;
    private Integer duration;
    private String destination;

    public UpdateRouteRequest(String aggregateId, Long id, String origin, Integer duration, String destination) {
        super(aggregateId);
        this.id = id;
        this.origin = origin;
        this.duration = duration;
        this.destination = destination;
    }

    public Long getId() {
        return id;
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
