package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.getFlightById.GetFlightsRequest;
import com.airsofka.flight.application.flight.getSeatsByFlight.GetSeatsByIdUseCase;
import com.airsofka.flight.application.flight.getSeatsByFlight.GetSeatsRequest;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seat")
public class GetSeatByIdController {
    private final GetSeatsByIdUseCase getSeatByIdUseCase;

    public GetSeatByIdController(GetSeatsByIdUseCase getSeatByIdUseCase) {
        this.getSeatByIdUseCase = getSeatByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<SeatResponse> getSeatById(@RequestBody GetSeatsRequest aggregateId) {
        System.out.println(aggregateId.getAggregateId());
        return ResponseEntity.ok(getSeatByIdUseCase.execute(aggregateId));
    }



}
