package com.airsofka.admin.application.admin.getallbookings;

import com.airsofka.admin.application.shared.ports.IEventConfirmedPort;
import com.airsofka.shared.application.IQueryUseCase;

import java.util.List;

public class GetAllBookingsUseCase {
    private final IEventConfirmedPort repository;

    public GetAllBookingsUseCase(IEventConfirmedPort repository) {
        this.repository = repository;
    }

    public List<BookingConfirmedResponse> execute() {
        return repository.findAllBookingsConfirmed();
    }
}
