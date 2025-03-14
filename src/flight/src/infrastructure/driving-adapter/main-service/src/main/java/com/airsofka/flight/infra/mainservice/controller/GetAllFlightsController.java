package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getFlights.GetFlightAllUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class GetAllFlightsController {
    private final GetFlightAllUseCase getFlightUseCase;

    public GetAllFlightsController(GetFlightAllUseCase getFlightUseCase) {
        this.getFlightUseCase = getFlightUseCase;
    }

    @GetMapping
    public ResponseEntity<List<FlightResponse>> getAllFlights() {
        return ResponseEntity.ok(getFlightUseCase.execute());
    }
}
