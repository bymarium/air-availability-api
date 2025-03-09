package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class SeatChanged extends DomainEvent {
    private String flightId;
    private String seatId;

    public SeatChanged(String flightId, String seatId) {
        super(EventsEnum.CHANGED_SEAT.name());
        this.flightId = flightId;
        this.seatId = seatId;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}
