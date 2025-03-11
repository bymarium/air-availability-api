package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.confirmbooking.ConfirmBookingUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/confirm-booking")
public class ConfirmBookingController {
    private final ConfirmBookingUseCase useCase;

    public ConfirmBookingController(ConfirmBookingUseCase useCase) {
        this.useCase = useCase;
    }
}
