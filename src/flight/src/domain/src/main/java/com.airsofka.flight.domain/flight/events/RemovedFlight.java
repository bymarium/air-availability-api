package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RemovedFlight extends DomainEvent {
    private String flightId;

    public RemovedFlight(String flightId) {
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
