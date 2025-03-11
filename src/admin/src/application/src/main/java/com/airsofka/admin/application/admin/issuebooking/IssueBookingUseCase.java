package com.airsofka.admin.application.admin.issuebooking;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class IssueBookingUseCase implements ICommandUseCase<IssueBookingRequest, Mono<AdminResponse>> {
    private final IEventRepositoryPort repository;

    public IssueBookingUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<AdminResponse> execute(IssueBookingRequest request) {
        return null;
    }
}
