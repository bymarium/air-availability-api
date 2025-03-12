package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getSeatsByFlight.GetSeatByIDUseCase;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
@CrossOrigin(origins = "http://localhost:4200")

public class GetSeatByIdController {
    private final GetSeatByIDUseCase getSeatByIdUseCase;

    public GetSeatByIdController(GetSeatByIDUseCase getSeatByIdUseCase) {
        this.getSeatByIdUseCase = getSeatByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<SeatResponse> getSeatById(@RequestBody String request) {
        return ResponseEntity.ok( getSeatByIdUseCase.execute(request));
    }



}
