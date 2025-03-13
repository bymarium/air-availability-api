package com.airsofka.authentication.infra.reservationapi.adapters;

import com.airsofka.authentication.application.shared.ports.IReservationAPIPort;
import com.airsofka.authentication.infra.reservationapi.entities.ReservationResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Random;


public class ReservationAPIAdapter implements IReservationAPIPort {
  private final WebClient webClient;

  public ReservationAPIAdapter(WebClient webClient) {
    this.webClient = webClient;
  }

  @Override
  public Mono<Integer> getReservationCounter(String email) {
//    return webClient.get()
//      .uri("/api/confirmed-booking")
//      .retrieve()
//      .bodyToMono(new ParameterizedTypeReference<List<ReservationResponse>>(){})
//      .map(response -> (int) response.stream()
//        .filter(reservation -> email.equals(reservation.getEmail()))
//        .count());
    return Mono.fromSupplier(() -> new Random().nextInt(20)+1);
  }
}
