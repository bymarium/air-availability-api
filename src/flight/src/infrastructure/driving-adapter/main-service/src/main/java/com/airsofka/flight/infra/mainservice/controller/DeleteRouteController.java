package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.route.deleteRoute.DeleteRouteRequest;
import com.airsofka.flight.application.route.deleteRoute.DeleteRouteUseCase;
import com.airsofka.flight.application.shared.route.RouteResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/delete-route")
public class DeleteRouteController {
    private final DeleteRouteUseCase deleteRouteUseCase;

    public DeleteRouteController(DeleteRouteUseCase deleteRouteUseCase) {
        this.deleteRouteUseCase = deleteRouteUseCase;

    }
    @DeleteMapping
    public Mono<RouteResponse> deleteRoute(@RequestBody DeleteRouteRequest request){
        return deleteRouteUseCase.execute(request);
    }
}