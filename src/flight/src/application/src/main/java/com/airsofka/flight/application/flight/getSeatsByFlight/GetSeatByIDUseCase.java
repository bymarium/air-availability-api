package com.airsofka.flight.application.flight.getSeatsByFlight;

import com.airsofka.flight.application.shared.flight.SeatResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

public class GetSeatByIDUseCase {
    private final IFlightRepositoryPort repository;
    public GetSeatByIDUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }

    public SeatResponse execute(String request) {
        return repository.findSeatsById(request);
    }
}
