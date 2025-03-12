package com.airsofkaapi.booking.application.createReservation;

import com.airsofka.shared.application.Request;
import com.airsofkaapi.booking.domain.shared.dtos.FlightDto;
import com.airsofkaapi.booking.domain.shared.dtos.PassengerDto;
import com.airsofkaapi.booking.domain.shared.dtos.PaymentDto;

import java.time.LocalDate;
import java.util.List;

public class CreateReservationRequest extends Request {
  private final LocalDate departureDate;
  private final LocalDate arrivalDate;
  private final String origin;
  private final String destination;
  private final String reservationCode;
  private final LocalDate creationDate;
  private final FlightDto originFlight;
  private final FlightDto destinationFlight;
  private final List<PassengerDto> passengers;
  private final PaymentDto payment;

  protected CreateReservationRequest() {
    super(null);
    this.departureDate = null;
    this.arrivalDate = null;
    this.origin = null;
    this.destination = null;
    this.reservationCode = null;
    this.creationDate = null;
    this.originFlight = null;
    this.destinationFlight = null;
    this.passengers = null;
    this.payment = null;
  }

  public CreateReservationRequest(LocalDate departureDate, LocalDate arrivalDate, String origin, String destination, String reservationCode, LocalDate creationDate, FlightDto originFlight, FlightDto destinationFlight, List<PassengerDto> passengers, PaymentDto payment) {
    super(null);
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.origin = origin;
    this.destination = destination;
    this.reservationCode = reservationCode;
    this.creationDate = creationDate;
    this.originFlight = originFlight;
    this.destinationFlight = destinationFlight;
    this.passengers = passengers;
    this.payment = payment;
  }

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public LocalDate getArrivalDate() {
    return arrivalDate;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public String getReservationCode() {
    return reservationCode;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public FlightDto getOriginFlight() {
    return originFlight;
  }

  public FlightDto getDestinationFlight() {
    return destinationFlight;
  }

  public List<PassengerDto> getPassengers() {
    return passengers;
  }

  public PaymentDto getPayment() {
    return payment;
  }
}
