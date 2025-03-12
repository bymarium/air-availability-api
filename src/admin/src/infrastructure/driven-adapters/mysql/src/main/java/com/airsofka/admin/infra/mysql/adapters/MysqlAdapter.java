package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;

import java.util.Optional;

public class MysqlAdapter implements IEventRepositoryBookingPort {

    private final BookingJpaRepository bookingJpaRepository;

    public MysqlAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public void saveBooking(Booking booking) {
        bookingJpaRepository.save(booking);
    }

    @Override
    public void updateStatus(Booking booking) {
        Optional<Booking> existingBooking = bookingJpaRepository.findById(booking.getIdentity());
        if (existingBooking.isPresent()) {
            Booking updatedBooking = existingBooking.get();
            updatedBooking.setState(booking.getState());
            bookingJpaRepository.save(updatedBooking);
        }
    }

}
