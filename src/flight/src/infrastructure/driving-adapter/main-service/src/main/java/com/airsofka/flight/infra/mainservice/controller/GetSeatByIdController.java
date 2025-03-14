package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getSeatsByFlight.GetSeatsByIdUseCase;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
public class GetSeatByIdController {
    private final GetSeatsByIdUseCase getSeatByIdUseCase;

    public GetSeatByIdController(GetSeatsByIdUseCase getSeatByIdUseCase) {
        this.getSeatByIdUseCase = getSeatByIdUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeatResponse> getSeatById(@PathVariable  String id) {
        return ResponseEntity.ok(getSeatByIdUseCase.execute(id));
    }



}
