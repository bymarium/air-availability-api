package com.airsofka.flight.application.flight.getFlights;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

import java.util.List;

public class GetFlightUseCase {
    private final IFlightRepositoryPort repository;
    public GetFlightUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }
    public List<FlightListResponse> execute() {
        return repository.findAll();
    }

}
