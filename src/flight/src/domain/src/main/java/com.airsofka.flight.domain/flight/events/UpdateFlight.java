package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.Date;

public class UpdateFlight extends DomainEvent {
    private String flightId;
    private String flightNumber;
    private String routeId;
    private String seatId;
    private Date departureTime;
    private Date arrivalTime;

    public UpdateFlight(String flightId, String flightNumber, String routeId, String seatId, Date departureTime, Date arrivalTime) {
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
    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

}
