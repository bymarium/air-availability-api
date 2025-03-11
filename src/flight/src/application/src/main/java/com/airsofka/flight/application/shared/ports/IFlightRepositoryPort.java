package com.airsofka.flight.application.shared.ports;


import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.domain.flight.Flight;

import java.util.List;

public interface IFlightRepositoryPort {
    void saveFlight(Flight flight);
    void updateFlight(Flight flight);
    List<FlightListResponse> findAll();
    FlightListResponse findById(String aggregateId);
}
