package com.airsofka.authentication.application.shared.ports;

import com.airsofka.authentication.application.shared.reservations.Reservation;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IReservationAPIPort {
  Mono<Integer> getReservationCounter(String email);
  Mono<List<Reservation>> getAllReservations();
  Mono<List<Reservation>> getReservations(String email);
  Mono<Reservation> getReservationsByCode(String code);
}
