package com.airsofka.flight.application.shared.flight;



import java.util.List;

public class FlightResponse {
    private final String flightId;
    private final String flightNumber;
    private final String routeId;
    private final String departureTime;
    private final String arrivalTime;
    private final String status;
    private final PricesInfo prices;
    private final List<seat> seats;

    public FlightResponse(String flightId, String flightNumber, String routeId, String departureTime, String arrivalTime, String status, PricesInfo prices, List<seat> seats) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.prices = prices;
        this.seats = seats;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getStatus() {
        return status;
    }

    public PricesInfo getPrices() {
        return prices;
    }

    public List<seat> getSeats() {
        return seats;
    }

    public static class seat {
        private final String seatId;
        private final String seatNumber;
        private final String seatClass;
        private final boolean isAvailable;
        private final double price;

        public seat(String seatId, String seatNumber, String seatClass, boolean isAvailable, double price) {
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatClass = seatClass;
            this.isAvailable = isAvailable;
            this.price = price;
        }

        // Getters
        public String getSeatId() {
            return seatId;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getSeatClass() {
            return seatClass;
        }

        public boolean getIsAvailable() {
            return isAvailable;
        }

        public double getPrice() {
            return price;
        }
    }
    public static class PricesInfo {
        private final Double priceStandar;
        private final Double childPrice;
        private final Double infantPrice;

        public PricesInfo(Double priceStandar, Double childPrice, Double infantPrice) {
            this.priceStandar = priceStandar;
            this.childPrice = childPrice;
            this.infantPrice = infantPrice;
        }

        // Getters
        public Double getPrice() {
            return priceStandar;
        }

        public Double getChildPrice() {
            return childPrice;
        }

        public Double getInfantPrice() {
            return infantPrice;
        }


    }
}
