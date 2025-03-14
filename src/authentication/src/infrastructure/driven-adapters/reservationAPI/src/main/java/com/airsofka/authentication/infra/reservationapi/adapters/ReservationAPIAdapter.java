package com.airsofka.authentication.infra.reservationapi.adapters;

import com.airsofka.authentication.application.shared.ports.IReservationAPIPort;
import com.airsofka.authentication.application.shared.reservations.Reservation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


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
//      .bodyToMono(new ParameterizedTypeReference<List<Reservation>>(){})
//      .map(response -> (int) response.stream()
//        .filter(reservation -> email.equals(reservation.getEmail()))
//        .count());
    return Mono.fromSupplier(() -> new Random().nextInt(20)+1);
  }

  @Override
  public Mono<List<Reservation>> getAllReservations() {
    return webClient.get()
      .uri("/api/confirmed-booking")
      .retrieve()
      .bodyToMono(new ParameterizedTypeReference<List<Reservation>>(){});
  }

  @Override
  public Mono<List<Reservation>> getReservations(String email) {
    return webClient.get()
      .uri("/api/confirmed-booking")
      .retrieve()
      .bodyToMono(new ParameterizedTypeReference<List<Reservation>>(){})
      .map(response -> response.stream()
        .filter(reservation -> email.equals(reservation.getEmail()))
        .collect(Collectors.toList()));
  }

  @Override
  public Mono<Reservation> getReservationsByCode(String code) {
    return webClient.get()
      .uri("/api/confirmed-booking")
      .retrieve()
      .bodyToMono(new ParameterizedTypeReference<List<Reservation>>(){})
      .map(response -> response.stream()
        .filter(reservation -> code.equalsIgnoreCase(reservation.getReservationCode()))
        .findFirst().get());
  }
}
