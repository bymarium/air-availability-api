package com.airsofka.flight.application.route.deleteRoute;

import com.airsofka.shared.application.Request;

public class DeleteRouteRequest extends Request {

    private Long id;

    public DeleteRouteRequest(String aggregateId, Long id) {
        super(aggregateId);
        this.id = id;

    }

    public Long getId() {
        return id;
    }
}