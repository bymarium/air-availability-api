package com.airsofkaapi.booking.application.createReservation;

import com.airsofka.shared.application.ICommandUseCase;
import com.airsofkaapi.booking.application.shared.ports.IEventsRepositoryPort;
import com.airsofkaapi.booking.application.shared.reservation.ReservationResponse;
import com.airsofkaapi.booking.domain.reservation.Reservation;
import reactor.core.publisher.Mono;

import static com.airsofkaapi.booking.application.shared.reservation.ReservationMapper.mapToReservation;

public class CreateReservationUseCase implements ICommandUseCase<CreateReservationRequest, Mono<ReservationResponse>> {
  private final IEventsRepositoryPort repository;

  public CreateReservationUseCase(IEventsRepositoryPort repository) {
    this.repository = repository;
  }

  @Override
  public Mono<ReservationResponse> execute(CreateReservationRequest request) {
    Reservation reservation = new Reservation(
      request.getDepartureDate(),
      request.getArrivalDate(),
      request.getOrigin(),
      request.getDestination(),
      request.getReservationCode(),
      request.getCreationDate(),
      request.getOriginFlight(),
      request.getDestinationFlight(),
      request.getPassengers(),
      request.getPayment()
    );

    reservation.getUncommittedEvents().forEach(repository::save);
    reservation.markEventsAsCommitted();
    return Mono.just(mapToReservation(reservation));
  }
}
