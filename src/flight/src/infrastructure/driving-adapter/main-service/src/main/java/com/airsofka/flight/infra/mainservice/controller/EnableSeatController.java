package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.enableSeat.EnableSeatRequest;
<<<<<<< HEAD
import com.airsofka.flight.application.flight.enableSeat.EnableSeatUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
=======
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> origin/main
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
<<<<<<< HEAD
@RestController
@RequestMapping("/api/enable-seat")
public class EnableSeatController {
    private final EnableSeatUseCase enableSeatController;

    public EnableSeatController(EnableSeatUseCase enableSeatController) {
        this.enableSeatController = enableSeatController;
    }

    @PutMapping
    public Mono<FlightResponse> enableSeat(@RequestBody EnableSeatRequest request) {
        return enableSeatController.execute(request);
=======

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
>>>>>>> origin/main
    }
}
