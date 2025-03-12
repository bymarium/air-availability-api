package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getFlightById.GetFlightByIDUseCase;
import com.airsofka.flight.application.flight.getFlightById.GetFlightsRequest;
import com.airsofka.flight.application.flight.getFlights.GetFlightUseCase;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get-flight")
public class GetFlightById {
    private final GetFlightUseCase getFlightByIdUseCase;

    public GetFlightById(GetFlightUseCase getFlightByIdUseCase) {
        this.getFlightByIdUseCase = getFlightByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<FlightListResponse> getFlightById(@RequestBody GetFlightsRequest request) {
        FlightListResponse flight = getFlightByIdUseCase.execute().stream()
                .filter(f -> f.getFlightId().equals(request.getAggregateId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        return ResponseEntity.ok(flight);
    }
}
