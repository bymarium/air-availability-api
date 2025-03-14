package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.getreservationbycode.GetReservationByCodeUseCase;
import com.airsofka.authentication.application.getreservationbycode.GetReservationBycodeRequest;
import com.airsofka.authentication.application.shared.reservations.Reservation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/get-reservation-by-code")
public class GetReservationByCodeController {
  private final GetReservationByCodeUseCase getReservationByCodeUseCase;

  public GetReservationByCodeController(GetReservationByCodeUseCase getReservationByCodeUseCase) {
    this.getReservationByCodeUseCase = getReservationByCodeUseCase;
  }

  @PostMapping
  public Mono<Reservation> execute(@RequestBody GetReservationBycodeRequest request){
    return getReservationByCodeUseCase.execute(request);
  }
}
