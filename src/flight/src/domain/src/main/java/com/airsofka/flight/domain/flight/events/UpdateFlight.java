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
    private Double price;

    public UpdateFlight(String flightId, String flightNumber, String routeId, String seatId, Date departureTime, Date arrivalTime, Double price) {
        super(EventsEnum.UPDATED_FLIGHT.name());
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.seatId = seatId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
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

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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
