package com.airsofka.flight.application.flight.createFlight;

import com.airsofka.flight.application.shared.flight.FlightMapper;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.flight.domain.flight.values.FlightNumber;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class CreateFlightUseCase implements ICommandUseCase<CreateFlightRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;

    public CreateFlightUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(CreateFlightRequest request) {
        Flight flight = new Flight(
                request.getFlightNumber(),
                request.getRouteId(),
                request.getPrice(),
                request.getDepartureTime(),
                request.getArrivalTime());
        flight.initializeSeats();
        flight.getUncommittedEvents().forEach(repository::save);
        flight.markEventsAsCommitted();

        return Mono.just(mapToResponse(flight));
    }
}
