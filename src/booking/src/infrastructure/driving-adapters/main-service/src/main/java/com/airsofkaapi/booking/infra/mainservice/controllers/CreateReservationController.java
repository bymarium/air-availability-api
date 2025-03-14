package com.airsofkaapi.booking.infra.mainservice.controllers;

import com.airsofkaapi.booking.application.createReservation.CreateReservationRequest;
import com.airsofkaapi.booking.application.createReservation.CreateReservationUseCase;
import com.airsofkaapi.booking.application.shared.reservation.ReservationResponse;
import com.airsofkaapi.booking.infra.sql.adapters.ReservationPublisherAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/booking/create-reservation")
public class CreateReservationController {
  private final CreateReservationUseCase useCase;
  private final ReservationPublisherAdapter reservationPublisher;

  public CreateReservationController(CreateReservationUseCase useCase, ReservationPublisherAdapter reservationPublisher) {
    this.useCase = useCase;
    this.reservationPublisher = reservationPublisher;
  }

  @PostMapping
  public Mono<ReservationResponse> execute(@RequestBody CreateReservationRequest request){
    return useCase.execute(request)
      .flatMap(reservationResponse ->
        reservationPublisher.publishReservation(reservationResponse)
          .thenReturn(reservationResponse)
        );
  }
}
