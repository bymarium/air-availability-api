package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.shared.application.Request;

public class CancelBookingRequest extends Request {
    private String id;
    private String bookingCode;
    private String state;

    public CancelBookingRequest() {
        super(null);
    }

    public CancelBookingRequest(String aggregateId, String id, String bookingCode, String state) {
        super(aggregateId);
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
