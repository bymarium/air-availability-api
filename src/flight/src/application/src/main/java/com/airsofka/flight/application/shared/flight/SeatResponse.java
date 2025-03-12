package com.airsofka.flight.application.shared.flight;

import com.airsofka.flight.domain.flight.values.SeatInfo;

import java.util.List;

public class SeatResponse {
    List<SeatInfo> seats;

    public SeatResponse(List<SeatInfo> seats) {
        this.seats = seats;
    }
    public List<SeatInfo> getSeats() {
        return seats;
    }

    public void setSeats(List<SeatInfo> seats) {
        this.seats = seats;
    }
    public static class SeatInfo {
        private final String seatId;
        private final String seatNumber;
        private final String seatClass;
        private final Boolean isAvailable;
        private final Double price;


        public SeatInfo(String seatId, String seatNumber, String seatClass, Boolean isAvailable, Double price) {
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatClass = seatClass;
            this.isAvailable = isAvailable;
            this.price = price;

        }

        public String getSeatId() {
            return seatId;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public String getSeatClass() {
            return seatClass;
        }

        public Boolean getAvailable() {
            return isAvailable;
        }

        public Double getPrice() {
            return price;
        }
    }


}
