package com.airsofka.authentication.application.shared.ports;

import reactor.core.publisher.Mono;

public interface IReservationAPIPort {
  Mono<Integer> getReservationCounter(String email);
}
