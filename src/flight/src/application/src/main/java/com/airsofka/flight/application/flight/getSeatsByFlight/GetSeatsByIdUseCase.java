package com.airsofka.flight.application.flight.getSeatsByFlight;

import com.airsofka.flight.application.flight.getFlightById.GetFlightsRequest;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

public class GetSeatsByIdUseCase {
    private final IFlightRepositoryPort repository;
    public GetSeatsByIdUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }

    public SeatResponse execute(GetSeatsRequest request) {
        return repository.findSeatsById(request.getAggregateId());
    }
}
