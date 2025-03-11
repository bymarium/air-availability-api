package com.airsofka.admin.application.shared;

import java.time.LocalDateTime;
import java.util.List;

public class AdminResponse {
    private final String adminId;
    private final List<Booking> booking;
    private final String email;
    private final Double income;
    private final String state;
    private final Double taxes;

    public AdminResponse(String adminId, List<Booking> booking, String email, Double income, String state, Double taxes) {
        this.adminId = adminId;
        this.booking = booking;
        this.email = email;
        this.income = income;
        this.state = state;
        this.taxes = taxes;
    }

    public String getAdminId() {
        return adminId;
    }

    public List<Booking> getBooking() {
        return booking;
    }

    public String getEmail() {
        return email;
    }

    public Double getIncome() {
        return income;
    }

    public String getState() {
        return state;
    }

    public Double getTaxes() {
        return taxes;
    }

    public static class Booking {
        private final LocalDateTime arrivalDate;
        private final String bookingCode;
        private final LocalDateTime creationDate;
        private final LocalDateTime departureDate;
        private final String Destination;
        private final String email;
        private final String flightClass;
        private final String origin;
        private final List<Passenger> passengers;
        private final String paymentMethod;
        private final Double price;
        private final String state;

        public Booking(LocalDateTime arrivalDate, String bookingCode, LocalDateTime creationDate, LocalDateTime departureDate, String destination, String email, String flightClass, String origin, List<Passenger> passengers, String paymentMethod, Double price, String state) {
            this.arrivalDate = arrivalDate;
            this.bookingCode = bookingCode;
            this.creationDate = creationDate;
            this.departureDate = departureDate;
            Destination = destination;
            this.email = email;
            this.flightClass = flightClass;
            this.origin = origin;
            this.passengers = passengers;
            this.paymentMethod = paymentMethod;
            this.price = price;
            this.state = state;
        }

        public LocalDateTime getArrivalDate() {
            return arrivalDate;
        }

        public String getBookingCode() {
            return bookingCode;
        }

        public LocalDateTime getCreationDate() {
            return creationDate;
        }

        public LocalDateTime getDepartureDate() {
            return departureDate;
        }

        public String getDestination() {
            return Destination;
        }

        public String getEmail() {
            return email;
        }

        public String getFlightClass() {
            return flightClass;
        }

        public String getOrigin() {
            return origin;
        }

        public List getPassengers() {
            return passengers;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public Double getPrice() {
            return price;
        }

        public String getState() {
            return state;
        }

        public static class Passenger {
            private final String bookerName;
            private final String email;

            public Passenger(String bookerName, String email) {
                this.bookerName = bookerName;
                this.email = email;
            }

            public String getBookerName() {
                return bookerName;
            }

            public String getEmail() {
                return email;
            }
        }
    }

}
