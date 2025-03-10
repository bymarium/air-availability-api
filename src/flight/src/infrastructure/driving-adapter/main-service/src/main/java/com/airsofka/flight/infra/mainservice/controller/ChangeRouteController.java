package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.changeRoute.ChangeRouteRequest;
import com.airsofka.flight.application.flight.changeRoute.ChangeRouteUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/change-route")
public class ChangeRouteController {
    private final ChangeRouteUseCase changeRouteUseCase;
    public ChangeRouteController(ChangeRouteUseCase changeRouteUseCase) {
        this.changeRouteUseCase = changeRouteUseCase;
    }

    @PostMapping
    public Mono<FlightResponse> changeRoute(@RequestBody ChangeRouteRequest request){
        return changeRouteUseCase.execute(request);
    }
}
