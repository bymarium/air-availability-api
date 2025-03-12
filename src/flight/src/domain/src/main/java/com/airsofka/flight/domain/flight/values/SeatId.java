package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.Identity;

public class SeatId extends Identity {
    public SeatId() {
        super();
    }

    public SeatId(String value) {
        super(value);
    }

    public static SeatId of(String value) {
        return new SeatId(value);
    }
}
