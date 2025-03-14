package com.airsofka.admin.application.admin.getallbookings;

import java.time.LocalDateTime;
import java.util.List;

public class BookingConfirmedResponse {

        private String id;
        private String state;
        private LocalDateTime departureDate;
        private LocalDateTime arrivalDate;
        private String origin;
        private String destination;
        private String reservationCode;
        private LocalDateTime creationDate;
        private List<String> passengers;

    public BookingConfirmedResponse(String id, String state, LocalDateTime departureDate, LocalDateTime arrivalDate, String origin, String destination, String reservationCode, LocalDateTime creationDate, List<String> passengers) {
        this.id = id;
        this.state = state;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.origin = origin;
        this.destination = destination;
        this.reservationCode = reservationCode;
        this.creationDate = creationDate;
        this.passengers = passengers;
    }

    public BookingConfirmedResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<String> passengers) {
        this.passengers = passengers;
    }
}
