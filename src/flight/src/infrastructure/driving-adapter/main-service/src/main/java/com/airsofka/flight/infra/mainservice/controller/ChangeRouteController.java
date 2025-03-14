package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.changeRoute.ChangeRouteRequest;
import com.airsofka.flight.application.flight.changeRoute.ChangeRouteUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PutMapping;
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> origin/main
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/flight-route")
=======
@RequestMapping("/api/change-route")
>>>>>>> origin/main
public class ChangeRouteController {
    private final ChangeRouteUseCase changeRouteUseCase;
    public ChangeRouteController(ChangeRouteUseCase changeRouteUseCase) {
        this.changeRouteUseCase = changeRouteUseCase;
    }
<<<<<<< HEAD
    @PutMapping
    public Mono<FlightResponse> changeRoute(@RequestBody ChangeRouteRequest request) {
=======

    @PostMapping
    public Mono<FlightResponse> changeRoute(@RequestBody ChangeRouteRequest request){
>>>>>>> origin/main
        return changeRouteUseCase.execute(request);
    }
}
