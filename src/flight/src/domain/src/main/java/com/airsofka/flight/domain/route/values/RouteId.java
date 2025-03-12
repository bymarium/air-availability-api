package com.airsofka.flight.domain.route.values;

import com.airsofka.shared.domain.generic.Identity;

public class RouteId extends Identity {
    public RouteId() {
        super();
    }

    public RouteId(String value) {
        super(value);
    }

    public static RouteId of(String value) {
        return new RouteId(value);
    }
}