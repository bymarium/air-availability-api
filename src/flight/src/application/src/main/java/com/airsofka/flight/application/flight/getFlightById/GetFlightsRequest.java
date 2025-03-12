package com.airsofka.flight.application.flight.getFlightById;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonCreator;

public class GetFlightsRequest extends Request {
    @JsonCreator
    public GetFlightsRequest(String aggregateId) {
        super(aggregateId);
    }
}
