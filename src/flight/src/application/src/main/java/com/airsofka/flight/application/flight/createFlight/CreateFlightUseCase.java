package com.airsofka.flight.application.flight.createFlight;

<<<<<<< HEAD
=======
import com.airsofka.flight.application.services.FlightService;
import com.airsofka.flight.application.shared.flight.FlightMapper;
>>>>>>> origin/main
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
<<<<<<< HEAD
=======
import com.airsofka.flight.domain.flight.values.FlightNumber;
import com.airsofka.infra.mongo.repositories.FlightRepository;
>>>>>>> origin/main
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class CreateFlightUseCase implements ICommandUseCase<CreateFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final FlightService flightService;

    public CreateFlightUseCase(IEventsRepositoryPort repository,FlightService flightRepository) {
        this.repository = repository;
        this.flightService = flightRepository;
    }

    @Override
    public Mono<FlightResponse> execute(CreateFlightRequest request) {
        Date departureTime = request.getDepartureTime();
        Instant newDepartureTime = departureTime.toInstant().plus(5, ChronoUnit.HOURS);
        Date updatedDepartureTime = Date.from(newDepartureTime);
        Date arrivalTime = request.getArrivalTime();
        Instant newArrivalTime = arrivalTime.toInstant().plus(5, ChronoUnit.HOURS);
        Date updatedArrivalTime = Date.from(newArrivalTime);
        Flight flight = new Flight(
                request.getFlightNumber(),
                request.getRouteId(),
                request.getPrice(),
<<<<<<< HEAD
                updatedDepartureTime,
                updatedArrivalTime,
                request.getFlightModel());
=======
                request.getDepartureTime(),
                request.getArrivalTime());
>>>>>>> origin/main

        flight.initializeSeats();
        flightService.saveFlight(flight);
        flight.getUncommittedEvents().forEach(repository::save);
        flight.markEventsAsCommitted();

        return Mono.just(mapToResponse(flight));
    }
}
