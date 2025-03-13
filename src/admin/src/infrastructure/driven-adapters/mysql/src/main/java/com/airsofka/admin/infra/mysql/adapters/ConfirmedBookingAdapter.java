package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.admin.getallbookings.BookingConfirmedResponse;
import com.airsofka.admin.application.shared.ports.IEventConfirmedPort;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConfirmedBookingAdapter implements IEventConfirmedPort {
    private final BookingJpaRepository bookingJpaRepository;

    @Autowired
    public ConfirmedBookingAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public List<BookingConfirmedResponse> findAllBookingsConfirmed() {
        return bookingJpaRepository.findByStateIgnoreCase("CONFIRMED")
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private BookingConfirmedResponse toResponse(BookingEntity booking) {
        return new BookingConfirmedResponse(
                booking.getId(),
                booking.getState(),
                booking.getDepartureDate(),
                booking.getArrivalDate(),
                booking.getOrigin(),
                booking.getDestination(),
                booking.getReservationCode(),
                booking.getCreationDate(),
                booking.getPassengers().stream()
                        .map(passenger -> passenger.getFirstName())
                        .collect(Collectors.toList())
        );
    }
}
