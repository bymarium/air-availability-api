package com.airsofka.flight.application.route.deleteRoute;

import com.airsofka.shared.application.Request;

public class DeleteRouteRequest extends Request {

    private String routerId;

    public DeleteRouteRequest(String aggregateId, String routerId) {
        super(aggregateId);
        this.routerId = routerId;

    }

    public String getRouterId() {
        return routerId;
    }
}