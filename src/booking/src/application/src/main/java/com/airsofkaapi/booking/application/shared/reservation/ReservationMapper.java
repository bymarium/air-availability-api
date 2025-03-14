package com.airsofkaapi.booking.application.shared.reservation;

import com.airsofkaapi.booking.domain.reservation.Reservation;

public class ReservationMapper {
  public static ReservationResponse mapToReservation(Reservation reservation){

    return new ReservationResponse(
      reservation.getIdentity().getValue(),
      reservation.getState().getValue(),
      reservation.getDepartureDate().getValue(),
      reservation.getArrivalDate().getValue(),
      reservation.getOrigin().getValue(),
      reservation.getDestination().getValue(),
      reservation.getReservationCode().getValue(),
      reservation.getCreationDate().getValue(),
      reservation.getOriginFlight().getRelationalId().getValue(),
      reservation.getDestinationFlight().getRelationalId().getValue(),
      reservation.getPassengers().stream().map(item -> new ReservationResponse.Passenger(
        item.getIdentity().getValue(),
        item.getType().getValue(),
        item.getFirstName().getValue(),
        item.getLastName().getValue(),
        item.getDocumentType().getValue(),
        item.getDocumentNumber().getValue(),
        item.getGender().getValue(),
        item.getBirthdayDate().getValue(),
        item.getEmail().getValue(),
        item.getPhone().getValue(),
        item.getOriginSeat().getValue(),
        item.getDestinationSeat().getValue()
      )).toList(),
      new ReservationResponse.Payment(
        reservation.getPayment().getIdentity().getValue(),
        reservation.getPayment().getPaymentMethod().getValue(),
        reservation.getPayment().getSubtotal().getValue(),
        reservation.getPayment().getTotal().getValue(),
        reservation.getPayment().getDiscount().getValue(),
        new ReservationResponse.Card(
          reservation.getPayment().getCard().getNumber(),
          reservation.getPayment().getCard().getHolderName(),
          reservation.getPayment().getCard().getExpirationDate(),
          reservation.getPayment().getCard().getCountryIssue()
        ),
        new ReservationResponse.Pse(
          reservation.getPayment().getPse().getHolderName(),
          reservation.getPayment().getPse().getEmail()
        ),
        new ReservationResponse.BillingAddress(
          reservation.getPayment().getBillingAddress().getAddressOne(),
          reservation.getPayment().getBillingAddress().getAddressTwo(),
          reservation.getPayment().getBillingAddress().getCountry(),
          reservation.getPayment().getBillingAddress().getCity(),
          reservation.getPayment().getBillingAddress().getState(),
          reservation.getPayment().getBillingAddress().getPostalCode(),
          reservation.getPayment().getBillingAddress().getPhoneNumber(),
          reservation.getPayment().getBillingAddress().getEmail()
        )
      )
    );

  }

}
