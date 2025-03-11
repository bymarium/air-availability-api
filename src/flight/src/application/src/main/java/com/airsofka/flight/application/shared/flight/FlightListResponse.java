package com.airsofka.flight.application.shared.flight;

import java.util.Date;
import java.util.List;

public class FlightListResponse {
    private final String flightId;
    private final String flightNumber;
    private final String flightModel;
    private final String routeId;
    private final Date departureTime;
    private final Date arrivalTime;
    private final String status;
    private final PricesInfo prices;
    private final Integer seats;
    private final Double tax;

    public FlightListResponse(String flightId, String flightNumber, String flightModel, String routeId, Date departureTime, Date arrivalTime, String status, PricesInfo prices, Integer seats, Double tax) {
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

    public PricesInfo getPrices() {
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
    public static class PricesInfo {

        private final Double standardPrice;
        private final List<PricePassengerInfo> passengerPrices;
        private final Double tax;

        public PricesInfo(Double standarPrice, List<PricePassengerInfo> passengerPrices, Double tax) {
            this.standardPrice = standarPrice;
            this.passengerPrices = passengerPrices;
            this.tax = tax;
        }

        // Getters
        public Double getPrice() {
            return standardPrice;
        }

        public Double getStandardPrice() {
            return standardPrice;
        }

        public List<PricePassengerInfo> getPassengerPrices() {
            return passengerPrices;
        }

        public Double getTax() {
            return tax;
        }
    }
    public static class PricePassengerInfo {
        private final String type;
        private final Double price;
        private final Double tax;
        private final Double totalPrice;

        public PricePassengerInfo(String type, Double price, Double tax, Double totalPrice) {
            this.type = type;
            this.price = price;
            this.tax = tax;
            this.totalPrice = totalPrice;
        }   // Getters

        public Double getPrice() {
            return price;
        }

        public Double getTax() {
            return tax;
        }

        public Double getTotalPrice() {
            return totalPrice;
        }

        public String getType() {
            return type;
        }
    }
}
