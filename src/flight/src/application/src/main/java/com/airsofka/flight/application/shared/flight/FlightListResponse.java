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
//    private final PricesInfo prices;
    private final Integer seats;
    private final Double tax;
    private final Double businessFullPrice;
    private final Double taxBusinessFullPrice;
    private final Double totalPriceBusinessFullPrice;
    private final Double businessBasicPrice;
    private final Double taxBusinessBasicPrice;
    private final Double totalPriceBusinessBasicPrice;
    private final Double economyFullPrice;
    private final Double taxEconomyFullPrice;
    private final Double totalPriceEconomyFullPrice;
    private final Double economyBasicPrice;
    private final Double taxEconomyBasicPrice;
    private final Double totalPriceEconomyBasicPrice;
    private final Double economyClassicPrice;
    private final Double taxEconomyClassicPrice;
    private final Double totalPriceEconomyClassicPrice;



    public FlightListResponse(String flightId, String flightNumber, String flightModel, String routeId, Date departureTime, Date arrivalTime, String status, Integer seats, Double tax, Double businessFullPrice, Double taxBusinessFullPrice, Double totalPriceBusinessFullPrice, Double businessBasicPrice, Double taxBusinessBasicPrice, Double totalPriceBusinessBasicPrice, Double economyFullPrice, Double taxEconomyFullPrice, Double totalPriceEconomyFullPrice, Double economyBasicPrice, Double taxEconomyBasicPrice, Double totalPriceEconomyBasicPrice, Double economyClassicPrice, Double taxEconomyClassicPrice, Double totalPriceEconomyClassicPrice) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.flightModel = flightModel;
        this.routeId = routeId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
        this.businessFullPrice = businessFullPrice;
        this.taxBusinessFullPrice = taxBusinessFullPrice;
        this.totalPriceBusinessFullPrice = totalPriceBusinessFullPrice;
        this.businessBasicPrice = businessBasicPrice;
        this.taxBusinessBasicPrice = taxBusinessBasicPrice;
        this.totalPriceBusinessBasicPrice = totalPriceBusinessBasicPrice;
        this.economyFullPrice = economyFullPrice;
        this.taxEconomyFullPrice = taxEconomyFullPrice;
        this.totalPriceEconomyFullPrice = totalPriceEconomyFullPrice;
        this.economyBasicPrice = economyBasicPrice;
        this.taxEconomyBasicPrice = taxEconomyBasicPrice;
        this.totalPriceEconomyBasicPrice = totalPriceEconomyBasicPrice;
        this.economyClassicPrice = economyClassicPrice;
        this.taxEconomyClassicPrice = taxEconomyClassicPrice;
        this.totalPriceEconomyClassicPrice = totalPriceEconomyClassicPrice;

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


    public Integer getSeats() {
        return seats;
    }

    public Double getTax() {
        return tax;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public Double getBusinessFullPrice() {
        return businessFullPrice;
    }

    public Double getTaxBusinessFullPrice() {
        return taxBusinessFullPrice;
    }

    public Double getTotalPriceBusinessFullPrice() {
        return totalPriceBusinessFullPrice;
    }

    public Double getBusinessBasicPrice() {
        return businessBasicPrice;
    }

    public Double getTaxBusinessBasicPrice() {
        return taxBusinessBasicPrice;
    }

    public Double getTotalPriceBusinessBasicPrice() {
        return totalPriceBusinessBasicPrice;
    }

    public Double getEconomyFullPrice() {
        return economyFullPrice;
    }

    public Double getTaxEconomyFullPrice() {
        return taxEconomyFullPrice;
    }

    public Double getTotalPriceEconomyFullPrice() {
        return totalPriceEconomyFullPrice;
    }

    public Double getEconomyBasicPrice() {
        return economyBasicPrice;
    }

    public Double getTaxEconomyBasicPrice() {
        return taxEconomyBasicPrice;
    }

    public Double getTotalPriceEconomyBasicPrice() {
        return totalPriceEconomyBasicPrice;
    }

    public Double getEconomyClassicPrice() {
        return economyClassicPrice;
    }

    public Double getTaxEconomyClassicPrice() {
        return taxEconomyClassicPrice;
    }

    public Double getTotalPriceEconomyClassicPrice() {
        return totalPriceEconomyClassicPrice;
    }

    //#region PassengerPriceInfo
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
            //#endregion

}
