package com.airsofka.flight.application.flight.changeSeat;

import com.airsofka.flight.application.shared.flight.FlightMapper;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ChangeSeatUseCase implements ICommandUseCase<ChangeSeatRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    private final IFlightRepositoryPort flightRepositoryPort;
    public ChangeSeatUseCase(IEventsRepositoryPort repository, IFlightRepositoryPort flightRepositoryPort) {
        this.flightRepositoryPort = flightRepositoryPort;
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(ChangeSeatRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.changedSeat(request.getSeatId());

                    flightRepositoryPort.changeSeat(request.getAggregateId(),request.getSeatId());
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return FlightMapper.mapToResponse(flight);
                });
    }
}
