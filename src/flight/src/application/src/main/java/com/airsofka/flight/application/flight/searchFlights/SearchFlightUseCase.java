package com.airsofka.flight.application.flight.searchFlights;

import com.airsofka.flight.application.shared.flight.FlightFullMapper;
import com.airsofka.flight.application.shared.flight.FlightMapper;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.infra.sql.entities.RouteEntity;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Flux;

import java.time.ZoneId;
import java.util.Date;

public class SearchFlightUseCase implements ICommandUseCase<SearchFlightRequest, Flux<FlightResponse>> {

  private final IFlightRepositoryPort flightRepository;
  private final IRouteRepositoryPort routeRepository;

  public SearchFlightUseCase(IFlightRepositoryPort flightRepository, IRouteRepositoryPort routeRepository) {
    this.flightRepository = flightRepository;
    this.routeRepository = routeRepository;
  }

  private record FlightWrapper(FlightListResponse flight, RouteEntity routeEntity) { }

  @Override
  public Flux<FlightResponse> execute(SearchFlightRequest request) {
    return Flux.fromIterable(flightRepository.findAll())
      .flatMap(flight ->
        routeRepository.findById(flight.getRouteId())
          .filter(routeEntity ->
            routeEntity.getOrigin().equalsIgnoreCase(request.getOrigin()) &&
              routeEntity.getDestination().equalsIgnoreCase(request.getDestination())
          )
          .map(routeEntity -> new FlightWrapper(flight, routeEntity))
      )
      .cast(FlightWrapper.class)
      .filter(wrapper -> {
        int requestedPassengers =
          (request.getPassengers().getAdults() != null ? request.getPassengers().getAdults() : 0) +
            (request.getPassengers().getChildren() != null ? request.getPassengers().getChildren() : 0) +
            (request.getPassengers().getInfants() != null ? request.getPassengers().getInfants() : 0);
        Integer availableSeats = wrapper.flight().getSeats();
        return availableSeats != null && availableSeats >= requestedPassengers;
      })
      .filter(wrapper -> {
        Date requestedDeparture = Date.from(request.getDates().getDeparture().atZone(ZoneId.systemDefault()).toInstant());
        Date requestedReturn = Date.from(request.getDates().getReturnDate().atZone(ZoneId.systemDefault()).toInstant());
        return wrapper.flight().getDepartureTime().equals(requestedDeparture)
          && wrapper.flight().getArrivalTime().equals(requestedReturn);
      })
      .map(wrapper -> FlightFullMapper.mapToResponse(wrapper.flight(), wrapper.routeEntity()));
  }
}
