package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsResponse;
import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generate-analytics")
public class GenerateAnalyticsController {
    private final GenerateAnalyticsUseCase useCase;

    public GenerateAnalyticsController(GenerateAnalyticsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
    public GenerateAnalyticsResponse generateAnalytics() {
        return useCase.execute();
    }
}
