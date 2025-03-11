package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate-analytics")
public class GenerateAnalyticsController {
    private final GenerateAnalyticsUseCase useCase;

    public GenerateAnalyticsController(GenerateAnalyticsUseCase useCase) {
        this.useCase = useCase;
    }
}
