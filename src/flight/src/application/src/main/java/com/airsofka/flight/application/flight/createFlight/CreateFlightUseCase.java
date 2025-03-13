package com.airsofka.flight.application.flight.createFlight;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class CreateFlightUseCase implements ICommandUseCase<CreateFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepositoryPort;


    public CreateFlightUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepository) {
        this.repository = repository;
        this.flightRepositoryPort = flightRepository;
    }

    @Override
    public Mono<FlightResponse> execute(CreateFlightRequest request) {
        Date departureTime = request.getDepartureTime();
        Instant newDepartureTime = departureTime.toInstant().plus(5, ChronoUnit.HOURS);
        Date updatedDepartureTime = Date.from(newDepartureTime);
        Date arrivalTime = request.getArrivalTime();
        Instant newArrivalTime = arrivalTime.toInstant().plus(5, ChronoUnit.HOURS);
        Date updatedArrivalTime = Date.from(newArrivalTime);

        System.out.println(updatedArrivalTime);
        System.out.println(updatedDepartureTime);
        Flight flight = new Flight(
                request.getFlightNumber(),
                request.getRouteId(),
                request.getPrice(),
                updatedDepartureTime,
                updatedArrivalTime,
                request.getFlightModel());
        System.out.println(flight.getIdentity().getValue());

        flight.initializeSeats();
        flightRepositoryPort.saveFlight(flight);
        flight.getUncommittedEvents().forEach(repository::save);
        flight.markEventsAsCommitted();

        return Mono.just(mapToResponse(flight));
    }
}
