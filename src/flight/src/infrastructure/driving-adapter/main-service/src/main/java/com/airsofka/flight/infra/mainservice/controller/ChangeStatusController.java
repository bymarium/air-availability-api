package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.changeStatus.ChangeStatusRequest;
import com.airsofka.flight.application.flight.changeStatus.ChangeStatusUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/change-status")
public class ChangeStatusController {
    private final ChangeStatusUseCase changeStatusUseCase;
    public ChangeStatusController(ChangeStatusUseCase changeStatusUseCase) {
        this.changeStatusUseCase = changeStatusUseCase;
    }

    @PutMapping
    public Mono<FlightResponse> changeStatus(@RequestBody ChangeStatusRequest request){
        return changeStatusUseCase.execute(request);
    }
}
