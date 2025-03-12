package com.airsofka.flight.application.route.deleteRoute;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonCreator;

public class DeleteRouteRequest extends Request {

    @JsonCreator
    public DeleteRouteRequest(String aggregateId) {
        super(aggregateId);
    }

}