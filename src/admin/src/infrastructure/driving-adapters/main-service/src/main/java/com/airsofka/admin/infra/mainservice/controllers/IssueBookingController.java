package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.issuebooking.IssueBookingUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issue-booking")
public class IssueBookingController {
    private final IssueBookingUseCase useCase;

    public IssueBookingController(IssueBookingUseCase useCase) {
        this.useCase = useCase;
    }
}
