package com.airsofka.authentication.application.getreservationbycode;

import com.airsofka.authentication.application.shared.ports.IReservationAPIPort;
import com.airsofka.authentication.application.shared.reservations.Reservation;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class GetReservationByCodeUseCase implements ICommandUseCase<GetReservationBycodeRequest, Mono<Reservation>> {
  private final IReservationAPIPort reservationAPIPort;

  public GetReservationByCodeUseCase(IReservationAPIPort reservationAPIPort) {
    this.reservationAPIPort = reservationAPIPort;
  }

  @Override
  public Mono<Reservation> execute(GetReservationBycodeRequest request) {
    return reservationAPIPort.getReservationsByCode(request.getCode());
  }
}
