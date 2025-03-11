package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.shared.application.Request;

public class DisplayRouteRequest extends Request {

    private Long id;

    public DisplayRouteRequest(String aggregateId, Long id) {
        super(aggregateId);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
