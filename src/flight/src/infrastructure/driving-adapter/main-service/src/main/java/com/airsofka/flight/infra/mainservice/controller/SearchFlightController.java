package com.airsofka.flight.infra.mainservice.controller;

import com.airsofka.flight.application.flight.searchFlights.SearchFlightUseCase;
import com.airsofka.flight.application.flight.searchFlights.SearchFlightRequest;
import com.airsofka.flight.application.shared.flight.FlightFullResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/search-flight")
public class SearchFlightController {
  private final SearchFlightUseCase searchFlightUseCase;

  public SearchFlightController(SearchFlightUseCase searchFlightUseCase) {
    this.searchFlightUseCase = searchFlightUseCase;
  }

  @PostMapping
  public Flux<FlightFullResponse> searchFlight(@Valid @RequestBody SearchFlightRequest request) {
    return searchFlightUseCase.execute(request);
  }
}
