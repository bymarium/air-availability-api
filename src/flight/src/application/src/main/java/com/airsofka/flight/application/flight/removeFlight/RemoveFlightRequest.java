package com.airsofka.flight.application.flight.removeFlight;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonCreator;

public class RemoveFlightRequest extends Request {
    @JsonCreator
    public RemoveFlightRequest(String aggregateId) {
        super(aggregateId);
    }
}
