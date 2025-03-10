package com.airsofka.flight.application.flight.enableSeat;

import com.airsofka.shared.application.Request;

public class EnableSeatRequest extends Request {
    private final String seatId;

    public EnableSeatRequest(String aggregateId, String seatId) {
        super(aggregateId);
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }
}
