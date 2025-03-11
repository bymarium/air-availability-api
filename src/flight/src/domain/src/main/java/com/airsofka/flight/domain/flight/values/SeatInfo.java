package com.airsofka.flight.domain.flight.values;

public class SeatInfo {
    private final String seatClass;
    private final double price;

    public SeatInfo(String seatClass, double price) {
        this.seatClass = seatClass;
        this.price = price;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public double getPrice() {
        return price;
    }

}
