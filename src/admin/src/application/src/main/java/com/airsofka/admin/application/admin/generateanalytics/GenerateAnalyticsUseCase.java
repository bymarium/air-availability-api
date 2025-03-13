package com.airsofka.admin.application.admin.generateanalytics;

import com.airsofka.admin.application.shared.ports.IEventRepositoryAnalyticsPort;
import com.airsofka.shared.application.IQueryUseCase;

public class GenerateAnalyticsUseCase implements IQueryUseCase<GenerateAnalyticsResponse> {
    private final IEventRepositoryAnalyticsPort repository;

    public GenerateAnalyticsUseCase(IEventRepositoryAnalyticsPort repository) {
        this.repository = repository;
    }

    @Override
    public GenerateAnalyticsResponse execute() {
        return repository.findAllBookings();
    }
}
