package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getFlights.GetFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get-flight")
public class GetFlightByIdController {
    private final GetFlightUseCase getFlightByIdUseCase;

    public GetFlightByIdController(GetFlightUseCase getFlightByIdUseCase) {
        this.getFlightByIdUseCase = getFlightByIdUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightListResponse> getFlightById(@PathVariable String id) {
        FlightListResponse flight = getFlightByIdUseCase.execute().stream()
                .filter(f -> f.getFlightId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        return ResponseEntity.ok(flight);
    }
}
