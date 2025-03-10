package com.airsofka.flight.application.shared.ports;


import com.airsofka.flight.domain.flight.Flight;

public interface IFlightRepositoryPort {
    void saveFlight(Flight flight);

}
