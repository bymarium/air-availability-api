package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.Identity;

public class FlightId extends Identity {
    public FlightId() {
        super();
    }

    public FlightId(String value) {
        super(value);
    }

    public static FlightId of(String value) {
        return new FlightId(value);
    }
}
