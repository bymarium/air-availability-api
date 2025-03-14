package com.airsofka.flight.application.flight.getFlights;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;

import java.util.List;

public class GetFlightAllUseCase {
    private final IFlightRepositoryPort repository;
    public GetFlightAllUseCase(IFlightRepositoryPort repository) {
        this.repository = repository;
    }
    public List<FlightResponse> execute() {
        return repository.findAllReseponse();
    }

}
