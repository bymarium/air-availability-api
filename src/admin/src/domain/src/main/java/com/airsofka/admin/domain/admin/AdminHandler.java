package com.airsofka.admin.domain.admin;

import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.events.CanceledBooking;
import com.airsofka.admin.domain.admin.events.ConfirmedBooking;
import com.airsofka.admin.domain.admin.events.GeneratedAnalytics;
import com.airsofka.admin.domain.admin.events.IssuedBooking;
import com.airsofka.admin.domain.admin.values.BookingCode;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class AdminHandler extends DomainActionsContainer {

    public AdminHandler(Admin admin) {
        addAction(cancelBooking(admin));
        addAction(confirmBooking(admin));
        addAction(GenerateAnalytics(admin));
        addAction(issueBooking(admin));
    }

    public Consumer<? extends DomainEvent> cancelBooking(Admin admin) {
        return (CanceledBooking event) -> {
            Booking booking = admin.getBookings().stream()
                    .filter(b -> b.getIdentity().equals(event.getId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

            booking.cancel(BookingCode.of(event.getBookingCode()));

            admin.setState(State.of(booking.getState().getValue()));
        };
    }

    public Consumer<? extends DomainEvent> confirmBooking(Admin admin) {
        return (ConfirmedBooking event) -> {
        };
    }

    public Consumer<? extends DomainEvent> GenerateAnalytics(Admin admin) {
        return (GeneratedAnalytics event) -> {
        };
    }

    public Consumer<? extends DomainEvent> issueBooking(Admin admin) {
        return (IssuedBooking event) -> {
            Booking booking = admin.getBookings().stream()
                    .filter(b -> b.getIdentity().equals(event.getId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

            booking.issue(BookingCode.of(event.getBookingCode()));

            admin.setState(State.of(booking.getState().getValue()));
        };
    }

}
