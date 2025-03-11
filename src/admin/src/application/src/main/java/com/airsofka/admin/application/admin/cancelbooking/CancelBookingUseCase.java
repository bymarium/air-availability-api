package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class CancelBookingUseCase implements ICommandUseCase<CancelBookingRequest, Mono<AdminResponse>> {
    private final IEventRepositoryPort repository;

    public CancelBookingUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AdminResponse> execute(CancelBookingRequest request) {
        return null;
    }
}
