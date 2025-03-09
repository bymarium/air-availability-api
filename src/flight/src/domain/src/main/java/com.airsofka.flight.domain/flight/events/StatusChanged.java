package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class StatusChanged extends DomainEvent {
    private String flightId;
    private String status;

    public StatusChanged(String flightId, String status) {
        super(EventsEnum.STATUS_CHANGED.name());
        this.flightId = flightId;
        this.status = status;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getStatus() {
        return status;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
