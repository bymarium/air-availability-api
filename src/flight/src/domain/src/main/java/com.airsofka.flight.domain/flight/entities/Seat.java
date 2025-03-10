package com.airsofka.flight.domain.flight.entities;

import com.airsofka.flight.domain.flight.values.IsAvailable;
import com.airsofka.flight.domain.flight.values.PriceSeat;
import com.airsofka.flight.domain.flight.values.SeatClass;
import com.airsofka.flight.domain.flight.values.SeatId;
import com.airsofka.flight.domain.flight.values.SeatNumber;
import com.airsofka.shared.domain.generic.Entity;

public class Seat extends Entity<SeatId> {
    private SeatNumber seatNumber;
    private SeatClass seatClass;
    private IsAvailable isAvailable;
    private PriceSeat priceSeat;

    public Seat(SeatId identity, SeatNumber seatNumber, SeatClass seatClass, IsAvailable isAvailable, PriceSeat priceSeat) {
        super(identity);
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = isAvailable;
        this.priceSeat = priceSeat;
    }

    public Seat(SeatNumber seatNumber, SeatClass seatClass, IsAvailable isAvailable, PriceSeat priceSeat) {
        super(new SeatId());
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = isAvailable;
        this.priceSeat = priceSeat;
    }

    public SeatNumber getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(SeatNumber seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public IsAvailable getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(IsAvailable isAvailable) {
        this.isAvailable = isAvailable;
    }

    public PriceSeat getPriceSeat() {
        return priceSeat;
    }

    public void setPriceSeat(PriceSeat priceSeat) {
        this.priceSeat = priceSeat;
    }
}
