package com.airsofka.flight.application.flight.assignRoute;

import com.airsofka.shared.application.Request;

public class AssignRouteRequest extends Request {
    private final String routeId;

    public AssignRouteRequest(String aggregateId, String routeId) {
        super(aggregateId);
        this.routeId = routeId;
    }

    public String getRouteId() {
        return routeId;
    }
}
