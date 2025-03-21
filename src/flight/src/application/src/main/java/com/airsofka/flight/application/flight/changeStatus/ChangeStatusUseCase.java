package com.airsofka.flight.application.flight.changeStatus;

import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

import static com.airsofka.flight.application.shared.flight.FlightMapper.mapToResponse;

public class ChangeStatusUseCase implements ICommandUseCase<ChangeStatusRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepositoryPort;
    public ChangeStatusUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepositoryPort) {
        this.flightRepositoryPort = flightRepositoryPort;
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(ChangeStatusRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.changeStatusFlight(request.getStatus());
                    flightRepositoryPort.updateStatus(flight);
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return mapToResponse(flight);
                });
    }
}
