package com.airsofka.flight.application.flight.changeRoute;

import com.airsofka.shared.application.Request;

public class ChangeRouteRequest extends Request {
    private final String routeId;

    public ChangeRouteRequest(String aggregateId, String routeId) {
        super(aggregateId);

        this.routeId = routeId;
    }

    public String getRouteId() {
        return routeId;
    }

}
