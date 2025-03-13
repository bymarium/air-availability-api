package com.airsofkaapi.booking.infra.sql.adapters;

import com.airsofkaapi.booking.domain.reservation.Reservation;
import com.airsofkaapi.booking.infra.sql.entities.BillingAddressEntity;
import com.airsofkaapi.booking.infra.sql.entities.CardEntity;
import com.airsofkaapi.booking.infra.sql.entities.PassengerEntity;
import com.airsofkaapi.booking.infra.sql.entities.PaymentEntity;
import com.airsofkaapi.booking.infra.sql.entities.PseEntity;
import com.airsofkaapi.booking.infra.sql.entities.ReservationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationAdapter {
  public static ReservationEntity toEntity(Reservation reservation){
    ReservationEntity entity = new ReservationEntity();
    entity.setId(reservation.getIdentity().getValue());
    entity.setState(reservation.getState().getValue());
    entity.setDepartureDate(reservation.getDepartureDate().getValue());
    entity.setArrivalDate(reservation.getArrivalDate().getValue());
    entity.setOrigin(reservation.getOrigin().getValue());
    entity.setDestination(reservation.getDestination().getValue());
    entity.setReservationCode(reservation.getReservationCode().getValue());
    entity.setCreationDate(reservation.getCreationDate().getValue());
    entity.setOriginFlightId(reservation.getOriginFlight().getRelationalId().getValue());
    entity.setDestinationFlightId(reservation.getDestinationFlight().getRelationalId().getValue());
    List<PassengerEntity> passengers = reservation.getPassengers().stream().map(
        passenger -> {
          PassengerEntity passengerEntity = new PassengerEntity();
          passengerEntity.setId(passenger.getIdentity().getValue());
          passengerEntity.setType(passenger.getType().getValue());
          passengerEntity.setFirstName(passenger.getFirstName().getValue());
          passengerEntity.setLastName(passenger.getLastName().getValue());
          passengerEntity.setDocumentType(passenger.getDocumentType().getValue());
          passengerEntity.setDocumentNumber(passenger.getDocumentNumber().getValue());
          passengerEntity.setGender(passenger.getGender().getValue());
          passengerEntity.setBirthdayDate(passenger.getBirthdayDate().getValue());
          passengerEntity.setEmail(passenger.getEmail().getValue());
          passengerEntity.setPhone(passenger.getPhone().getValue());
          passengerEntity.setOriginSeat(passenger.getOriginSeat().getValue());
          passengerEntity.setDestinationSeat(passenger.getDestinationSeat().getValue());
          passengerEntity.setReservation(entity);
          return passengerEntity;
        }
    ).collect(Collectors.toList());
    entity.setPassengers(passengers);
    
    PaymentEntity payment = new PaymentEntity();
    payment.setId(reservation.getPayment().getIdentity().getValue());
    payment.setPaymentMethod(reservation.getPayment().getPaymentMethod().getValue());
    payment.setSubtotal(reservation.getPayment().getSubtotal().getValue());
    payment.setTotal(reservation.getPayment().getTotal().getValue());
    payment.setDiscount(reservation.getPayment().getDiscount().getValue());   
        
    CardEntity card = new CardEntity();
    card.setNumber(reservation.getPayment().getCard().getNumber());
    card.setHolderName(reservation.getPayment().getCard().getHolderName());
    card.setExpirationDate(reservation.getPayment().getCard().getExpirationDate());
    card.setCountryIssue(reservation.getPayment().getCard().getCountryIssue());
    
    payment.setCard(card);
    
    PseEntity pse = new PseEntity();
    pse.setHolderName(reservation.getPayment().getPse().getHolderName());
    pse.setEmail(reservation.getPayment().getPse().getEmail());
    
    payment.setPse(pse);

    BillingAddressEntity billingAddress = new BillingAddressEntity();
    billingAddress.setAddressOne(reservation.getPayment().getBillingAddress().getAddressOne());
    billingAddress.setAddressTwo(reservation.getPayment().getBillingAddress().getAddressTwo());
    billingAddress.setCountry(reservation.getPayment().getBillingAddress().getCountry());
    billingAddress.setCity(reservation.getPayment().getBillingAddress().getCity());
    billingAddress.setState(reservation.getPayment().getBillingAddress().getState());
    billingAddress.setPostalCode(reservation.getPayment().getBillingAddress().getPostalCode());
    billingAddress.setPhoneNumber(reservation.getPayment().getBillingAddress().getPhoneNumber());
    billingAddress.setEmail(reservation.getPayment().getBillingAddress().getEmail());
    
    payment.setBillingAddress(billingAddress);
    entity.setPayment(payment);
    
    return entity;
  }

}
