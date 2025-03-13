package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingRequest;
import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import com.airsofka.admin.application.shared.AdminResponse;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cancel-booking")
public class CancelBookingController {
    private final CancelBookingUseCase useCase;

    public CancelBookingController(CancelBookingUseCase useCase) {
        this.useCase = useCase;
    }

    @PutMapping
    public Mono<AdminResponse> cancelBooking(@RequestBody CancelBookingRequest request) {
        return useCase.execute(request);
    }

}
