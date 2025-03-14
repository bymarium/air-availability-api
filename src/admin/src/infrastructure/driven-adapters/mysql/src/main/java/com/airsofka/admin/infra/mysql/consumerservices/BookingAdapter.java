package com.airsofka.admin.infra.mysql.consumerservices;

import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.stereotype.Component;

@Component
public class BookingAdapter {

    private final BookingJpaRepository bookingJpaRepository;

    public BookingAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }


    public void updateStatus(BookingEntity booking) {
        BookingEntity bookingEntity = bookingJpaRepository.findById(booking.getId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + booking.getId()));

        if (bookingEntity.getState().equals("PENDING")) {
            bookingEntity.setState("CONFIRMED");
        }

        System.out.println("Updating booking state to: " + booking.getState());
        bookingJpaRepository.save(bookingEntity);
        System.out.println("Booking state updated for ID: " + bookingEntity.getId());
    }
}