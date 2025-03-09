package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.createFlight.CreateFlightRequest;
import com.airsofka.flight.application.flight.createFlight.CreateFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-flight")
public class CreateFlightController {
    private final CreateFlightUseCase createFlightUseCase;

    public CreateFlightController(CreateFlightUseCase createFlightUseCase) {
        this.createFlightUseCase = createFlightUseCase;
    }
    @PostMapping
    public Mono<FlightResponse> createFlight(@RequestBody CreateFlightRequest request){
        return createFlightUseCase.execute(request);
    }
}
