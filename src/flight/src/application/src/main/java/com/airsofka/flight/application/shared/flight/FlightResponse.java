package com.airsofka.flight.application.shared.flight;



import java.util.List;

public class FlightResponse {
    private final String flightId;
    private final String flightNumber;
    private final String flightModel;
    private final String routeId;
    private final String departureTime;
    private final String arrivalTime;
    private final String status;
    private final PricesInfo prices;
    private final List<seat> seats;

    public FlightResponse(String flightId, String flightNumber, String flightModel, String routeId, String departureTime, String arrivalTime, String status, PricesInfo prices, List<seat> seats) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightModel = flightModel;
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

    public String getFlightModel() {
        return flightModel;
    }

    public static class seat {
        private final String seatId;
        private final String seatNumber;
        private final String seatClass;
        private final boolean isAvailable;
        private final double price;
        private final int row;
        private final String column;

        public seat(String seatId, String seatNumber, String seatClass, boolean isAvailable, double price, int row, String column) {
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatClass = seatClass;
            this.isAvailable = isAvailable;
            this.price = price;
            this.row = row;
            this.column = column;
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

        public boolean isAvailable() {
            return isAvailable;
        }

        public int getRow() {
            return row;
        }

        public String getColumn() {
            return column;
        }
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
