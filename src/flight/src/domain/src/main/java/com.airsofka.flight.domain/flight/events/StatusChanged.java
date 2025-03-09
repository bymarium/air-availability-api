package com.airsofka.flight.domain.flight.events;

public class StatusChanged {
    private String flightId;
    private String status;

    public StatusChanged(String flightId, String status) {
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
