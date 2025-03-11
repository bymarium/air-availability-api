package com.airsofkaapi.booking.domain.reservation;

import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;
import com.airsofkaapi.booking.domain.reservation.entities.Flight;
import com.airsofkaapi.booking.domain.reservation.entities.Passenger;
import com.airsofkaapi.booking.domain.reservation.entities.Payment;
import com.airsofkaapi.booking.domain.reservation.events.CreatedReservation;
import com.airsofkaapi.booking.domain.reservation.values.BillingAddress;
import com.airsofkaapi.booking.domain.reservation.values.BirthdayDate;
import com.airsofkaapi.booking.domain.reservation.values.Card;
import com.airsofkaapi.booking.domain.reservation.values.Category;
import com.airsofkaapi.booking.domain.reservation.values.DocumentNumber;
import com.airsofkaapi.booking.domain.reservation.values.DocumentType;
import com.airsofkaapi.booking.domain.reservation.values.Email;
import com.airsofkaapi.booking.domain.reservation.values.Gender;
import com.airsofkaapi.booking.domain.reservation.values.Hour;
import com.airsofkaapi.booking.domain.reservation.values.Money;
import com.airsofkaapi.booking.domain.reservation.values.PassengerType;
import com.airsofkaapi.booking.domain.reservation.values.PaymentMethod;
import com.airsofkaapi.booking.domain.reservation.values.Phone;
import com.airsofkaapi.booking.domain.reservation.values.Pse;
import com.airsofkaapi.booking.domain.reservation.values.RegularDate;
import com.airsofkaapi.booking.domain.reservation.values.RegularName;
import com.airsofkaapi.booking.domain.reservation.values.ReservationCode;
import com.airsofkaapi.booking.domain.reservation.values.Seat;
import com.airsofkaapi.booking.domain.reservation.values.State;
import com.airsofkaapi.booking.domain.shared.dtos.PassengerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReservationHandler extends DomainActionsContainer {
  public ReservationHandler(Reservation reservation) {
    add(createReservation(reservation));
  }

  public Consumer<? extends DomainEvent> createReservation(Reservation reservation){
    return (CreatedReservation event) ->{
      reservation.setState(State.of("PENDING"));
      reservation.setDepartureDate(RegularDate.of(event.getDepartureDate()));
      reservation.setArrivalDate(RegularDate.of(event.getArrivalDate()));
      reservation.setOrigin(RegularName.of(event.getOrigin()));
      reservation.setDestination(RegularName.of(event.getDestination()));
      reservation.setReservationCode(ReservationCode.of(event.getReservationCode()));
      reservation.setCreationDate(RegularDate.of(event.getCreationDate()));
      Flight originFlight = new Flight(
        Money.of(event.getOriginFlight().getPrice()),
        Category.of(event.getOriginFlight().getCategory()),
        Hour.of(event.getOriginFlight().getStartTime()),
        Hour.of(event.getOriginFlight().getEndTime())
      );
      reservation.setOriginFlight(originFlight);
      Flight destinationFlight = new Flight(
        Money.of(event.getDestinationFlight().getPrice()),
        Category.of(event.getDestinationFlight().getCategory()),
        Hour.of(event.getDestinationFlight().getStartTime()),
        Hour.of(event.getDestinationFlight().getEndTime())
      );
      reservation.setDestinationFlight(destinationFlight);
      List<Passenger> passengers = new ArrayList<>();
      for(PassengerDto passengerDto : event.getPassengers()) {
        passengers.add(new Passenger(
          PassengerType.of(passengerDto.getType()),
          RegularName.of(passengerDto.getFirstName()),
          RegularName.of(passengerDto.getLastName()),
          DocumentType.of(passengerDto.getDocumentType()),
          DocumentNumber.of(passengerDto.getDocumentNumber()),
          Gender.of(passengerDto.getGender()),
          BirthdayDate.of(passengerDto.getBirthdayDate()),
          Email.of(passengerDto.getEmail()),
          Phone.of(passengerDto.getPhone()),
          Seat.of(passengerDto.getOriginSeat()),
          Seat.of(passengerDto.getDestinationSeat())
        ));
      }
      reservation.setPassengers(passengers);

      String paymentMethod = event.getPayment().getPaymentMethod();
      Card card = null;
      Pse pse = null;
      if(paymentMethod.equals("CARD")){
        card = Card.of(
          event.getPayment().getCard().getNumber(),
          event.getPayment().getCard().getHolderName(),
          event.getPayment().getCard().getExpirationDate(),
          event.getPayment().getCard().getCountryIssue()
        );
        pse = Pse.of("","");
      }
      else if(paymentMethod.equals("PSE")){
        card = Card.of("","","","");
        pse = Pse.of(
          event.getPayment().getPse().getHolderName(),
          event.getPayment().getPse().getEmail()
        );
      }
      BillingAddress billingAddress =  BillingAddress.of(
        event.getPayment().getBillingAddress().getAddressOne(),
        event.getPayment().getBillingAddress().getAddressOne(),
        event.getPayment().getBillingAddress().getCountry(),
        event.getPayment().getBillingAddress().getCity(),
        event.getPayment().getBillingAddress().getState(),
        event.getPayment().getBillingAddress().getPostalCode(),
        event.getPayment().getBillingAddress().getPhoneNumber(),
        event.getPayment().getBillingAddress().getEmail()
      );

      Payment payment = new Payment(
        Money.of(event.getPayment().getSubtotal()),
        Money.of(event.getPayment().getDiscount()),
        Money.of(event.getPayment().getTotal()),
        PaymentMethod.of(event.getPayment().getPaymentMethod()),
        card,
        pse,
        billingAddress
      );
      reservation.setPayment(payment);
    };
  }

}
