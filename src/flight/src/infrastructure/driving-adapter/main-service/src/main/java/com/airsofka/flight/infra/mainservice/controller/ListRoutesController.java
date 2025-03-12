package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.route.listRoutes.ListRoutesUseCase;
import com.airsofka.flight.application.shared.route.RouteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class ListRoutesController {
    private final ListRoutesUseCase listRoutesUseCase;

    public ListRoutesController(ListRoutesUseCase listRoutesUseCase) {
        this.listRoutesUseCase = listRoutesUseCase;
    }

    @GetMapping
    public ResponseEntity<List<RouteResponse>> getAllRoutes() {
        return ResponseEntity.ok(listRoutesUseCase.execute());
    }

}