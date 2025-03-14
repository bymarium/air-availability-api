package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getFlights.GetFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class GetFlightsController {
    private final GetFlightUseCase getFlightUseCase;
    public GetFlightsController(GetFlightUseCase getFlightUseCase) {
        this.getFlightUseCase = getFlightUseCase;
    }
    @GetMapping
    public ResponseEntity<List<FlightListResponse>> getAllFlights() {
        return ResponseEntity.ok(getFlightUseCase.execute());
    }

}
