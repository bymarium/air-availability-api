package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cancel-booking")
public class CancelBookingController {
    private final CancelBookingUseCase useCase;

    public CancelBookingController(CancelBookingUseCase useCase) {
        this.useCase = useCase;
    }

}
