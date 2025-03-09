package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class UpdateFlight extends DomainEvent {
    private String flightId;
    private String flightNumber;
    private String routeId;
    private String seatId;

    public UpdateFlight(String flightId, String flightNumber, String routeId, String seatId) {
        super(EventsEnum.UPDATED_FLIGHT.name());
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.seatId = seatId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getSeatId() {
        return seatId;
    }
}
