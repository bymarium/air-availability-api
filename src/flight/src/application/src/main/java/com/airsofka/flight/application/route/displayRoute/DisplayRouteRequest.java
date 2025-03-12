package com.airsofka.flight.application.route.displayRoute;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonCreator;

public class DisplayRouteRequest extends Request {

    @JsonCreator
    public DisplayRouteRequest(String aggregateId) {
        super(aggregateId);
    }


}
