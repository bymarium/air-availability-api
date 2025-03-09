package com.airsofka.flight.application.flight.createFlight;

import com.airsofka.shared.application.Request;

import java.util.Date;

public class CreateFlightRequest extends Request {
    private final String flightNumber;
    private final String routeId;
    private final Date departureTime;
    private final Date arrivalTime;

    public CreateFlightRequest(String aggregateId, String flightNumber, String routeId, Date departureTime, Date arrivalTime) {
        super(aggregateId);
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getRouteId() {
        return routeId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }
}
