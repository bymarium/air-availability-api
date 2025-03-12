package com.airsofkaapi.booking.infra.mainservice.controllers;

import com.airsofkaapi.booking.application.createReservation.CreateReservationRequest;
import com.airsofkaapi.booking.application.createReservation.CreateReservationUseCase;
import com.airsofkaapi.booking.application.shared.reservation.ReservationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/booking/create-reservation")
public class CreateReservationController {
  private final CreateReservationUseCase useCase;

  public CreateReservationController(CreateReservationUseCase useCase) {
    this.useCase = useCase;
  }

  @PostMapping
  public Mono<ReservationResponse> execute(@RequestBody CreateReservationRequest request){
    return useCase.execute(request);
  }
}
