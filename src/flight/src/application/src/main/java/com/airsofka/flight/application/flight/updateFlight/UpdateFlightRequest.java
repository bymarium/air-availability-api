package com.airsofka.flight.application.flight.updateFlight;

import com.airsofka.shared.application.Request;

import java.util.Date;

public class UpdateFlightRequest extends Request {
    private final String flightNumber;
    private final String routeId;
    private final String seatId;
    private final Date departureTime;
    private final Date arrivalTime;
    private final Double price;

    public UpdateFlightRequest(String aggregateId, String flightNumber, String routeId, String seatId, Date departureTime, Date arrivalTime, Double price) {
        super(aggregateId);
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.seatId = seatId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }
}
