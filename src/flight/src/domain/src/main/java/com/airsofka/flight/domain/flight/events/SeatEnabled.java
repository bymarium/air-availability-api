package com.airsofka.flight.domain.flight.events;


import com.airsofka.shared.domain.generic.DomainEvent;

public class SeatEnabled extends DomainEvent {
    private String seatId;

    public SeatEnabled(String seatId) {
        super(EventsEnum.SEAT_ENABLED.name());
        this.seatId = seatId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}

