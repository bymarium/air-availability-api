package com.airsofka.authentication.application.toggleuser;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToggleUserRequest extends Request {
    public ToggleUserRequest(@JsonProperty("aggregateId") String aggregateId) {
        super(aggregateId);
    }
}
