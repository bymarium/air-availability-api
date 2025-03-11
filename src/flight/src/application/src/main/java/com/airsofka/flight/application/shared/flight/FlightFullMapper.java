package com.airsofka.flight.application.shared.flight;
import com.airsofka.infra.sql.entities.RouteEntity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlightFullMapper {

  public static FlightFullResponse mapToResponse(FlightListResponse flight, RouteEntity route) {
    String duration = calculateDuration(flight.getDepartureTime(), flight.getArrivalTime());
    String operatingAirline = "Copa Airlines";

    double standardPrice = flight.getStandardPrice() != null ? flight.getStandardPrice() : 0.0;
    double economicPrice = flight.getEconomicPrice() != null ? flight.getEconomicPrice() : 0.0;
    double favorablePrice = flight.getFavorablePrice() != null ? flight.getFavorablePrice() : 0.0;
    double executivePrice = flight.getExecutivePrice() != null ? flight.getExecutivePrice() : 0.0;
    double executiveFullPrice = flight.getExecutiveFullPrice() != null ? flight.getExecutiveFullPrice() : 0.0;

    return new FlightFullResponse(
      flight.getFlightId(),
      flight.getFlightNumber(),
      flight.getFlightModel(),
      duration,
      operatingAirline,
      route.getOrigin(),
      route.getDestination(),
      flight.getDepartureTime().toString(),
      flight.getArrivalTime().toString(),
      new FlightFullResponse.PricesInfo(
        standardPrice,
        economicPrice,
        favorablePrice,
        executivePrice,
        executiveFullPrice
      )
    );
  }

  private static String calculateDuration(Date departure, Date arrival) {
    long diffMillis = arrival.getTime() - departure.getTime();
    long hours = TimeUnit.MILLISECONDS.toHours(diffMillis);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis) % 60;
    return String.format("%d:%02d", hours, minutes);
  }
}
