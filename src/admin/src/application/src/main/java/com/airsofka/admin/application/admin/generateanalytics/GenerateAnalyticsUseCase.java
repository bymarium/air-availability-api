package com.airsofka.admin.application.admin.generateanalytics;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class GenerateAnalyticsUseCase implements ICommandUseCase<GenerateAnalyticsRequest, Mono<AdminResponse>> {
    private final IEventRepositoryPort repository;

    public GenerateAnalyticsUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AdminResponse> execute(GenerateAnalyticsRequest request) {
        return null;
    }
}
