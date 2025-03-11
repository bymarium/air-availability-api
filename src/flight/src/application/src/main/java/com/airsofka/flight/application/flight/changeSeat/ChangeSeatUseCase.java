package com.airsofka.flight.application.flight.changeSeat;

import com.airsofka.flight.application.shared.flight.FlightMapper;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class ChangeSeatUseCase implements ICommandUseCase<ChangeSeatRequest, Mono<FlightResponse>> {
    private final IEventsRepositoryPort repository;
    public ChangeSeatUseCase(IEventsRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Mono<FlightResponse> execute(ChangeSeatRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Flight flight = Flight.from(request.getAggregateId(), events);
                    flight.changedSeat(request.getSeatId());
                    flight.getUncommittedEvents().forEach(repository::save);
                    flight.markEventsAsCommitted();
                    return FlightMapper.mapToResponse(flight);
                });
    }
}
