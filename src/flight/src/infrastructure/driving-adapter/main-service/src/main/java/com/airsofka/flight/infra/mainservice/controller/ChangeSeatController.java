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
<<<<<<< HEAD
@RequestMapping("/api/flight-seat")
public class ChangeSeatController {
    private final ChangeSeatUseCase changeSeatUseCase;
=======
    @RequestMapping("/api/change-seat")
public class ChangeSeatController {
    private final ChangeSeatUseCase changeSeatUseCase;

>>>>>>> origin/main
    public ChangeSeatController(ChangeSeatUseCase changeSeatUseCase) {
        this.changeSeatUseCase = changeSeatUseCase;
    }
    @PutMapping
<<<<<<< HEAD
    public Mono<FlightResponse> changeSeat(@RequestBody ChangeSeatRequest request) {
=======
    public Mono<FlightResponse> changeSeat(@RequestBody ChangeSeatRequest request){
>>>>>>> origin/main
        return changeSeatUseCase.execute(request);
    }
}
