package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.changeStatus.ChangeStatusRequest;
import com.airsofka.flight.application.flight.changeStatus.ChangeStatusUseCase;
import com.airsofka.flight.application.flight.getFlightById.GetFlightsRequest;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/flight-status")
public class UpdateFlightStatus {
    private final ChangeStatusUseCase changeStatusUseCase;

    public UpdateFlightStatus(ChangeStatusUseCase changeStatusUseCase) {
        this.changeStatusUseCase = changeStatusUseCase;
    }

    @PutMapping
    public Mono<FlightResponse> getFlightById(@RequestBody ChangeStatusRequest request) {
        return changeStatusUseCase.execute(request);
    }
}
