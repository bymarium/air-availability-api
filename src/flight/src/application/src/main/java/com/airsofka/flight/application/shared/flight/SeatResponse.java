package com.airsofka.flight.application.shared.flight;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeatResponse {
    List<SeatInfo> seats;

    public SeatResponse(List<SeatInfo> seats) {
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

        public SeatInfo(String seatId, String seatNumber, String seatClass, Boolean isAvailable, Double price, Integer row, String column) {
            this.seatId = seatId;
            this.seatNumber = seatNumber;
            this.seatClass = seatClass;
            this.isAvailable = isAvailable;
            this.price = price;
            this.row = row;
            this.column = column;
        }

    }


}
