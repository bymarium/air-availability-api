package com.airsofka.admin.domain.admin.values;

import com.airsofka.shared.domain.generic.Identity;

public class BookingId extends Identity {
    public BookingId() {
        super();
    }

    private BookingId(String value) {
        super(value);
    }

    public static BookingId of(String value) {
        return new BookingId(value);
    }
}
