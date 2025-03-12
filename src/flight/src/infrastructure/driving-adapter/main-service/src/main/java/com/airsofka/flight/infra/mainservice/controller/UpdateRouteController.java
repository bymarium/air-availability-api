package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.route.updateRoute.UpdateRouteRequest;
import com.airsofka.flight.application.route.updateRoute.UpdateRouteUseCase;
import com.airsofka.flight.application.shared.route.RouteResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/update-route")
public class UpdateRouteController {
    private final UpdateRouteUseCase updateRouteUseCase;

    public UpdateRouteController(UpdateRouteUseCase updateRouteUseCase) {
        this.updateRouteUseCase = updateRouteUseCase;
    }

    @PutMapping
    public Mono<RouteResponse> updateRoute(@RequestBody UpdateRouteRequest request) {
        return updateRouteUseCase.execute(request);
    }
}