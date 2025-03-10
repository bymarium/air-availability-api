package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;

import com.airsofka.infra.sql.entities.FlightEntity;
import com.airsofka.infra.sql.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySQLAdapter implements IFlightRepositoryPort {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightAdapter flightAdapter;

    public MySQLAdapter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void saveFlight(Flight flight) {
        FlightEntity flightEntity = FlightAdapter.toEntity(flight);
        flightRepository.save(flightEntity);
    }

}
