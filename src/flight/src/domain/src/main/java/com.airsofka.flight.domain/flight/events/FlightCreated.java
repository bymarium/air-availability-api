package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class FlightCreated extends DomainEvent {
    private String flightId;
    private String flightNumber;

    public FlightCreated(String flightId, String flightNumber) {
        super(EventsEnum.CREATED_FLIGHT.name());
        this.flightId = flightId;
        this.flightNumber = flightNumber;
    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
