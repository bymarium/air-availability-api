package com.airsofka.admin.application.shared.consumerservices;

import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final BookingJpaRepository bookingJpaRepository;

    public BookingService(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Transactional
    public void saveBookingState(String bookingId, String newState) {
        BookingEntity bookingEntity = bookingJpaRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + bookingId));

        bookingEntity.setState(newState);

        System.out.println("Updating booking state to: " + newState);
        bookingJpaRepository.save(bookingEntity);
        System.out.println("Booking state updated for ID: " + bookingEntity.getId());
    }
}
