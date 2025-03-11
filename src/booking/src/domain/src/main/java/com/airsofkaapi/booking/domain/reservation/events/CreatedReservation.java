package com.airsofkaapi.booking.domain.reservation.events;

import com.airsofka.shared.domain.generic.DomainEvent;
import com.airsofkaapi.booking.domain.shared.dtos.FlightDto;
import com.airsofkaapi.booking.domain.shared.dtos.PassengerDto;
import com.airsofkaapi.booking.domain.shared.dtos.PaymentDto;

import java.time.LocalDate;
import java.util.List;

public class CreatedReservation extends DomainEvent {
  private LocalDate departureDate;
  private LocalDate arrivalDate;
  private String origin;
  private String destination;
  private String reservationCode;
  private LocalDate creationDate;
  private FlightDto originFlight;
  private FlightDto destinationFlight;
  private List<PassengerDto> passengers;
  private PaymentDto payment;

  public CreatedReservation(LocalDate departureDate, LocalDate arrivalDate, String origin, String destination, String reservationCode, LocalDate creationDate, FlightDto originFlight, FlightDto destinationFlight, List<PassengerDto> passengers, PaymentDto payment) {
    super(EventsEnum.CREATED_RESERVATION.name());
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
