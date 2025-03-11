package com.airsofka.flight.domain.flight.events;

import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.Date;

public class FlightCreated extends DomainEvent {
    private String flightId;
    private String flightNumber;
    private String routeId;
    private Double price;
    private Date departureTime;
    private Date arrivalTime;

    public FlightCreated(String flightId, String flightNumber, String routeId, Double price, Date departureTime, Date arrivalTime) {
        super(EventsEnum.CREATED_FLIGHT.name());
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.price = price;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
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

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
