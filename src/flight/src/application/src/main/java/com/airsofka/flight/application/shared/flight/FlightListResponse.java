package com.airsofka.flight.application.shared.flight;

import java.util.Date;

public class FlightListResponse {
    private final String flightId;
    private final String flightNumber;
    private final String flightModel;
    private final String routeId;
    private final Date departureTime;
    private final Date arrivalTime;
    private final String status;
    private final Double prices;
    private final Integer seats;
    private final Double tax;

    public FlightListResponse(String flightId, String flightNumber, String flightModel, String routeId, Date departureTime, Date arrivalTime, String status, Double prices, Integer seats, Double tax) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightModel = flightModel;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.prices = prices;
        this.seats = seats;
        this.tax = tax;
    }

    // Getters
    public String getFlightId() {
        return flightId;
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

    public String getStatus() {
        return status;
    }

    public Double getPrices() {
        return prices;
    }

    public Integer getSeats() {
        return seats;
    }

    public Double getTax() {
        return tax;
    }

    public String getFlightModel() {
        return flightModel;
    }
}
