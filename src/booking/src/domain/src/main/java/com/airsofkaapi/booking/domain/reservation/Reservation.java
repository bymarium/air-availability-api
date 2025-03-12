package com.airsofkaapi.booking.domain.reservation;

import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofkaapi.booking.domain.reservation.entities.Flight;
import com.airsofkaapi.booking.domain.reservation.entities.Passenger;
import com.airsofkaapi.booking.domain.reservation.entities.Payment;
import com.airsofkaapi.booking.domain.reservation.events.CreatedReservation;
import com.airsofkaapi.booking.domain.reservation.values.RegularDate;
import com.airsofkaapi.booking.domain.reservation.values.RegularName;
import com.airsofkaapi.booking.domain.reservation.values.ReservationCode;
import com.airsofkaapi.booking.domain.reservation.values.ReservationId;
import com.airsofkaapi.booking.domain.reservation.values.State;
import com.airsofkaapi.booking.domain.shared.dtos.FlightDto;
import com.airsofkaapi.booking.domain.shared.dtos.PassengerDto;
import com.airsofkaapi.booking.domain.shared.dtos.PaymentDto;

import java.time.LocalDate;
import java.util.List;

public class Reservation extends AggregateRoot<ReservationId> {
  private State state;
  private RegularDate departureDate;
  private RegularDate arrivalDate;
  private RegularName origin;
  private RegularName destination;
  private ReservationCode reservationCode;
  private RegularDate creationDate;
  private Flight originFlight;
  private Flight destinationFlight;
  private List<Passenger> passengers;
  private Payment payment;

  // region Constructors
  public Reservation(LocalDate departureDate, LocalDate arrivalDate, String origin, String destination, String reservationCode, LocalDate creationDate, FlightDto originFlight, FlightDto destinationFlight, List<PassengerDto> passengers, PaymentDto payment){
    super(new ReservationId());
    subscribe(new ReservationHandler(this));
    apply(new CreatedReservation(departureDate, arrivalDate, origin, destination, reservationCode, creationDate, originFlight, destinationFlight, passengers, payment));
  }

  private Reservation(ReservationId identity) {
    super(identity);
    subscribe(new ReservationHandler(this));
  }
  //endregion

  // region Getters and Setters
  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public RegularDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(RegularDate departureDate) {
    this.departureDate = departureDate;
  }

  public RegularDate getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(RegularDate arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public RegularName getOrigin() {
    return origin;
  }

  public void setOrigin(RegularName origin) {
    this.origin = origin;
  }

  public RegularName getDestination() {
    return destination;
  }

  public void setDestination(RegularName destination) {
    this.destination = destination;
  }

  public ReservationCode getReservationCode() {
    return reservationCode;
  }

  public void setReservationCode(ReservationCode reservationCode) {
    this.reservationCode = reservationCode;
  }

  public RegularDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(RegularDate creationDate) {
    this.creationDate = creationDate;
  }

  public Flight getOriginFlight() {
    return originFlight;
  }

  public void setOriginFlight(Flight originFlight) {
    this.originFlight = originFlight;
  }

  public Flight getDestinationFlight() {
    return destinationFlight;
  }

  public void setDestinationFlight(Flight destinationFlight) {
    this.destinationFlight = destinationFlight;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public void setPassengers(List<Passenger> passengers) {
    this.passengers = passengers;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }
  //endregion
}
