package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.route.displayRoute.DisplayRouteRequest;
import com.airsofka.flight.application.route.displayRoute.DisplayRouteUseCase;
import com.airsofka.flight.application.shared.route.RouteResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-route")
public class DisplayRouteController {
    private final DisplayRouteUseCase displayRouteUseCase;

    public DisplayRouteController(DisplayRouteUseCase displayRouteUseCase) {
        this.displayRouteUseCase = displayRouteUseCase;
    }

    @GetMapping("/{id}")
    public Mono<RouteResponse> getRouteById(@RequestBody DisplayRouteRequest request) {
        return displayRouteUseCase.execute(request);
    }
}