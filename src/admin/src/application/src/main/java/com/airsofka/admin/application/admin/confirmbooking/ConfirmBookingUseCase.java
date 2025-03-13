package com.airsofka.admin.application.admin.confirmbooking;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ConfirmBookingUseCase implements ICommandUseCase<ConfirmBookingRequest, Mono<AdminResponse>> {
    private final IEventRepositoryPort repository;

    public ConfirmBookingUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AdminResponse> execute(ConfirmBookingRequest request) {
        return null;
    }
}
