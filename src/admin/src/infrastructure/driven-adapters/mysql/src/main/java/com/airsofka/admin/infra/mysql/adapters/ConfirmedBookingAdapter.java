package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.admin.getallbookings.BookingConfirmedResponse;
import com.airsofka.admin.application.shared.ports.IEventConfirmedPort;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.entities.PassengerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ConfirmedBookingAdapter implements IEventConfirmedPort {

    private final List<BookingEntity> bookings;

    public ConfirmedBookingAdapter(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    @Override
    public List<BookingConfirmedResponse> findAllBookingsConfirmed() {
        return bookings.stream()
                .filter(booking -> "CONFIRMED".equalsIgnoreCase(booking.getState()))
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
                        .map(PassengerEntity::getFirstName)
                        .collect(Collectors.toList())
        );
    }

}
