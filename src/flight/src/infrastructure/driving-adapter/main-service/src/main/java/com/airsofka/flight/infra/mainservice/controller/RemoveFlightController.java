package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.removeFlight.RemoveFlightRequest;
import com.airsofka.flight.application.flight.removeFlight.RemoveFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/flight")
public class RemoveFlightController {
    private final RemoveFlightUseCase removeFlightUseCase;

    public RemoveFlightController(RemoveFlightUseCase removeFlightUseCase) {
        this.removeFlightUseCase = removeFlightUseCase;
    }

    @DeleteMapping
    public Mono<FlightResponse> removeFlight(@RequestBody RemoveFlightRequest request) {
        return removeFlightUseCase.execute(request);
    }
}
