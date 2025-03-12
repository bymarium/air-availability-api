package com.airsofka.flight.application.flight.searchFlights;

import com.airsofka.flight.application.shared.flight.FlightFullMapper;
import com.airsofka.flight.application.shared.flight.FlightFullResponse;
import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.application.shared.ports.IRouteRepositoryPort;
import com.airsofka.flight.application.shared.route.RouteResponse;
import com.airsofka.flight.domain.route.Route;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.ZoneId;

public class SearchFlightUseCase implements ICommandUseCase<SearchFlightRequest, Flux<FlightFullResponse>> {

  private final IFlightRepositoryPort flightRepository;
  private final IRouteRepositoryPort routeRepository;

  public SearchFlightUseCase(IFlightRepositoryPort flightRepository, IRouteRepositoryPort routeRepository) {
    this.flightRepository = flightRepository;
    this.routeRepository = routeRepository;
  }

  private record FlightWrapper(FlightListResponse flight, RouteResponse route) { }

  @Override
  public Flux<FlightFullResponse> execute(SearchFlightRequest request) {
    LocalDate requestDate = request.getDate().toLocalDate();

    return Flux.fromIterable(flightRepository.findAll())
      .flatMap(flight ->
        Mono.justOrEmpty(routeRepository.findById(flight.getRouteId()))
          .filter(routeEntity ->
            routeEntity.getOrigin().equals(request.getOrigin()) &&
              routeEntity.getDestination().equals(request.getDestination())
          )
          .map(routeEntity -> new FlightWrapper(flight, routeEntity))
      )
      .filter(wrapper -> {
        int requestedPassengers =
          (request.getPassengers().getAdults() != null ? request.getPassengers().getAdults() : 0) +
            (request.getPassengers().getChildren() != null ? request.getPassengers().getChildren() : 0) +
            (request.getPassengers().getInfants() != null ? request.getPassengers().getInfants() : 0);
        Integer availableSeats = wrapper.flight().getSeats();
        return availableSeats != null && availableSeats >= requestedPassengers;
      })
      .filter(wrapper -> {
        LocalDate flightDate = wrapper.flight().getDepartureTime().toInstant()
          .atZone(ZoneId.systemDefault())
          .toLocalDate();
        boolean dateMatches = flightDate.equals(requestDate);
        System.out.println("Flight date: " + flightDate + ", Request date: " + requestDate + ", Matches: " + dateMatches);
        return flightDate.equals(requestDate);
      })
      .map(wrapper -> FlightFullMapper.mapToResponse(wrapper.flight(), wrapper.route()));
  }
}