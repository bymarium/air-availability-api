package com.airsofka.flight.application.shared.flight;



import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FlightResponse {
    private final String flightId;
    private final String flightNumber;
    private final String flightModel;
    private final String routeId;
    private final String departureTime;
    private final String arrivalTime;
    private final String status;
    private final PricesInfo prices;
    private final List<SeatInfo> seats;

    public FlightResponse(String flightId, String flightNumber, String flightModel, String routeId, String departureTime, String arrivalTime, String status, PricesInfo prices, List<SeatInfo> seats) {
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



    @Getter
    @Setter
    public static class SeatInfo {
        private final String seatId;
        private final String seatNumber;
        private final String seatClass;
        private final Boolean isAvailable;
        private final Double price;
        private final Integer row;
        private final String column;

        public SeatInfo(String seatId, String seatNumber, String seatClass, boolean isAvailable, double price, int row, String column) {
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatClass = seatClass;
            this.isAvailable = isAvailable;
            this.price = price;
            this.row = row;
            this.column = column;
        }


    }
    @Getter
    @Setter
    public static class PricesInfo {

        private final Double standardPrice;
        private final List<PricePassengerInfo> passengerPrices;
        private final Double tax;

        public PricesInfo(Double standarPrice, List<PricePassengerInfo> passengerPrices, Double tax) {
            this.standardPrice = standarPrice;
            this.passengerPrices = passengerPrices;
            this.tax = tax;
        }



    }
    @Getter
    @Setter
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
        }


    }
}
