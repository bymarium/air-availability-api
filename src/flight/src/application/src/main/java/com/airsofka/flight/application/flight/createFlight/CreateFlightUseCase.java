package com.airsofka.flight.application.flight.createFlight;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

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
        Flight flight = new Flight(
                request.getFlightNumber(),
                request.getRouteId(),
                request.getPrice(),
                request.getDepartureTime(),
                request.getArrivalTime(),
                request.getFlightModel());
        flight.initializeSeats();
        flightRepositoryPort.saveFlight(flight);
        flight.getUncommittedEvents().forEach(repository::save);
        flight.markEventsAsCommitted();

        return Mono.just(mapToResponse(flight));
    }
}
