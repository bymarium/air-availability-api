package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.entities.PaymentEntity;

public class BookingAdapter {
    public static BookingEntity toEntity(Booking booking){
        BookingEntity entity = new BookingEntity();

        entity.setId(booking.getIdentity().getValue());
        entity.setState(booking.getState().getValue());
        entity.setDestination(booking.getDestination().getValue());
        entity.setOrigin(booking.getOrigin().getValue());
        entity.setPassengers(booking.getPassengers().getValue());
        entity.setArrivalDate(booking.getArrivalDate().getValue());
        entity.setDepartureDate(booking.getDepartureDate().getValue());
        entity.setReservationCode(booking.getBookingCode().getValue());

        PaymentEntity payment = new PaymentEntity();
        payment.setPaymentMethod(booking.getPaymentMethod().getValue());
        payment.setTotal(booking.getPrice().getValue());

        return entity;
    }
}
