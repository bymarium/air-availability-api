package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.changeSeat.ChangeSeatRequest;
import com.airsofka.flight.application.flight.changeSeat.ChangeSeatUseCase;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
    @RequestMapping("/api/change-seat")
public class ChangeSeatController {
    private final ChangeSeatUseCase changeSeatUseCase;

    public ChangeSeatController(ChangeSeatUseCase changeSeatUseCase) {
        this.changeSeatUseCase = changeSeatUseCase;
    }
    @PutMapping
    public Mono<FlightResponse> changeSeat(@RequestBody ChangeSeatRequest request){
        return changeSeatUseCase.execute(request);
    }
}
