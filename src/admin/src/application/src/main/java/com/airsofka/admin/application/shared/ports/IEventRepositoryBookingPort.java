package com.airsofka.admin.application.shared.ports;

import com.airsofka.admin.domain.admin.entities.Booking;

public interface IEventRepositoryBookingPort {
    void saveBooking(Booking booking);

    void updateStatus(Booking booking);

}
