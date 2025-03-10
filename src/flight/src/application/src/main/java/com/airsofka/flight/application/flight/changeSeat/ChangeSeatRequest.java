package com.airsofka.flight.application.flight.changeSeat;

import com.airsofka.shared.application.Request;

public class ChangeSeatRequest extends Request {
    private final String seatId;

    public ChangeSeatRequest(String aggregateId, String seatId) {
        super(aggregateId);
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }
}
