package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.updateFlight.UpdateFlightRequest;
import com.airsofka.flight.application.flight.updateFlight.UpdateFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/update-flight")
public class UpdateFlightController {
    private final UpdateFlightUseCase updateFlightUseCase;
    public UpdateFlightController(UpdateFlightUseCase updateFlightUseCase) {
        this.updateFlightUseCase = updateFlightUseCase;
    }
    @PutMapping
    public Mono<FlightResponse> updateFlight(@RequestBody UpdateFlightRequest request){
        return updateFlightUseCase.execute(request);
    }
}
