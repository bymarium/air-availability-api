package com.airsofka.flight.application.flight.getFlightById;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

public class GetFlightByIdUseCase {
    private final IFlightRepositoryPort repository;
    public GetFlightByIdUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }

    public FlightListResponse execute(GetFlightsRequest request) {
        return repository.findById(request.getAggregateId());

    }
}
