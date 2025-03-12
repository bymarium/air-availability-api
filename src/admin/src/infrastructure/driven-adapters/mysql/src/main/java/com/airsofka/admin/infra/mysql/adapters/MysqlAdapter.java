package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;

import java.util.Optional;

public class MysqlAdapter implements IEventRepositoryBookingPort {

    private BookingJpaRepository bookingJpaRepository;

    private BookingAdapter bookingAdapter;

    public MysqlAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public void saveBooking(Booking booking) {
        BookingEntity bookingEntity = BookingAdapter.toEntity(booking);
        bookingJpaRepository.save(bookingEntity);
    }

    @Override
    public void updateStatus(Booking booking) {
        Optional<BookingEntity> existingBooking = bookingJpaRepository.findById(booking.getIdentity().getValue());
        if (existingBooking.isPresent()) {
            BookingEntity updatedBooking = BookingAdapter.toEntity(booking);
            updatedBooking.setId(existingBooking.get().getId());
            updatedBooking.setState(booking.getState().getValue());
            bookingJpaRepository.save(updatedBooking);
        }
    }


}
