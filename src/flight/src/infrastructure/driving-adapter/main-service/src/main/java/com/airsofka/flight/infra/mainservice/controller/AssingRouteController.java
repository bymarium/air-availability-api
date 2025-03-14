package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.assignRoute.AssignRouteRequest;
import com.airsofka.flight.application.flight.assignRoute.AssignRouteUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/assing-route")
public class AssingRouteController {
    private final AssignRouteUseCase assingRouteUseCase;

    public AssingRouteController(AssignRouteUseCase assingRouteUseCase) {
        this.assingRouteUseCase = assingRouteUseCase;
    }

    @PostMapping
    public Mono<FlightResponse> assingRoute(@RequestBody AssignRouteRequest request) {
        return assingRouteUseCase.execute(request);
    }

}
