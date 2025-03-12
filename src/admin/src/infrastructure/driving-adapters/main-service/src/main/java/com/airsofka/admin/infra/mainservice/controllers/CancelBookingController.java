package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingRequest;
import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import com.airsofka.admin.application.shared.AdminResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cancel-booking")
public class CancelBookingController {
    private final CancelBookingUseCase useCase;

    public CancelBookingController(CancelBookingUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public Mono<AdminResponse> cancelBooking(@RequestBody CancelBookingRequest request) {
        return useCase.execute(request);
    }

}
