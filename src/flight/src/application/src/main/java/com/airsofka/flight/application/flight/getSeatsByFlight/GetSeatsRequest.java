package com.airsofka.flight.application.flight.getSeatsByFlight;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonCreator;

public class GetSeatsRequest extends Request {
    @JsonCreator
    public GetSeatsRequest(String aggregateId) {
        super(aggregateId);
    }
}
