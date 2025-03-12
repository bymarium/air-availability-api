package com.airsofka.flight.application.flight.changeStatus;

import com.airsofka.shared.application.Request;

public class ChangeStatusRequest extends Request {
    private final String status;

    public ChangeStatusRequest(String aggregateId, String status) {
        super(aggregateId);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
