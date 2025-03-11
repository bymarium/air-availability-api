package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.route.createRoute.CreateRouteRequest;
import com.airsofka.flight.application.route.createRoute.CreateRouteUseCase;
import com.airsofka.flight.application.shared.route.RouteResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/create-route")
public class CreateRouteController {
    private final CreateRouteUseCase createRouteUseCase;

    public CreateRouteController(CreateRouteUseCase createRouteUseCase) {
        this.createRouteUseCase = createRouteUseCase;

    }
    @PostMapping
    public Mono<RouteResponse> createRoute(@RequestBody CreateRouteRequest request){
        return createRouteUseCase.execute(request);
    }
}