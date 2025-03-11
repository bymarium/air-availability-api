package com.airsofka.admin.application.shared;

import com.airsofka.admin.domain.admin.Admin;

import java.util.List;
import java.util.stream.Collectors;

public class AdminMapper {

    public static AdminResponse mapToAdmin(Admin admin) {
        return new AdminResponse(
                admin.getIdentity().getValue(),
                admin.getBookings().stream().map(booking ->
                        new AdminResponse.Booking(
                                booking.getArrivalDate().getValue(),
                                booking.getBookingCode().getValue(),
                                booking.getCreationDate().getValue(),
                                booking.getDepartureDate().getValue(),
                                booking.getDestination().getValue(),
                                booking.getEmail().getValue(),
                                booking.getFlightClass().getValue(),
                                booking.getOrigin().getValue(),
                                booking.getPassengers().getValue(),
                                booking.getPaymentMethod().getValue(),
                                booking.getPrice().getValue(),
                                booking.getState().getValue()
                        )
                ).collect(Collectors.toList()),
                admin.getEmail().getValue(),
                admin.getIncome().getValue(),
                admin.getState().getValue(),
                admin.getTaxes().getValue()
        );
    }
}
