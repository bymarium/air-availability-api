package com.airsofka.flight.application.flight.getFlightById;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

public class GetFlightByIDUseCase {
    private final IFlightRepositoryPort repository;
    public GetFlightByIDUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }

    public FlightListResponse execute(GetFlightsRequest request) {
        return repository.findById(request.getAggregateId());

    }
}
