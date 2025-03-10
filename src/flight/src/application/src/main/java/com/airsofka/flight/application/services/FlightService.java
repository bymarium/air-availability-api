package com.airsofka.flight.application.services;

import com.airsofka.flight.application.flight.createFlight.CreateFlightRequest;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.infra.mongo.adapters.FlightAdapter;
import com.airsofka.infra.mongo.entities.FlightEntity;
import com.airsofka.infra.mongo.entities.PriceEntity;
import com.airsofka.infra.mongo.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
   @Autowired
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }
    public void saveFlight(Flight request) {
        FlightEntity flight = FlightAdapter.toEntity(request);
        flightRepository.save(flight);
    }
}
