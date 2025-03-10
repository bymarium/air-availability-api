package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.enableSeat.EnableSeatRequest;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/enable-seat")
public class EnableSeatController {
    private final EnableSeatController enableSeatController;

    public EnableSeatController(EnableSeatController enableSeatController) {
        this.enableSeatController = enableSeatController;
    }

    @PostMapping
    public Mono<FlightResponse> enableSeat(@RequestBody EnableSeatRequest request) {
        return enableSeatController.enableSeat(request);
    }
}
