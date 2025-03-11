package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class FlightRemoved extends DomainEvent {
    private String flightId;

    public FlightRemoved(String flightId) {
        super(EventsEnum.REMOVED_FLIGHT.name());
        this.flightId = flightId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
