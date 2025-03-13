package com.airsofka.admin.domain.admin.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class IssuedBooking extends DomainEvent {
    private String id;
    private String bookingCode;
    private String state;

    public IssuedBooking() {
        super(EventsEnum.ISSUED_BOOKING.name());
    }

    public IssuedBooking(String id, String bookingCode, String state) {
        super(EventsEnum.ISSUED_BOOKING.name());
        this.id = id;
        this.bookingCode = bookingCode;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
