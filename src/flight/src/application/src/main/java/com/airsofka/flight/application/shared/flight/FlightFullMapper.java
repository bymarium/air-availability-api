package com.airsofka.flight.application.shared.flight;
import com.airsofka.infra.sql.entities.RouteEntity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlightFullMapper {

  public static FlightFullResponse mapToResponse(FlightListResponse flight, RouteEntity route) {
    String duration = calculateDuration(flight.getDepartureTime(), flight.getArrivalTime());
    String operatingAirline = "Copa Airlines";

    double standardPrice = flight.getEconomyBasicPrice() != null ? flight.getEconomyBasicPrice() : 0.0;
    double economicPrice = flight.getEconomyClassicPrice() != null ? flight.getEconomyClassicPrice() : 0.0;
    double favorablePrice = flight.getEconomyFullPrice() != null ? flight.getEconomyFullPrice() : 0.0;
    double executivePrice = flight.getBusinessBasicPrice() != null ? flight.getBusinessBasicPrice() : 0.0;
    double executiveFullPrice = flight.getBusinessFullPrice() != null ? flight.getBusinessFullPrice() : 0.0;

    double standardTax = flight.getTaxEconomyBasicPrice() != null ? flight.getTaxEconomyBasicPrice() : 0.0;
    double economicTax = flight.getTaxEconomyClassicPrice() != null ? flight.getTaxEconomyClassicPrice() : 0.0;
    double favorableTax = flight.getTaxEconomyFullPrice() != null ? flight.getTaxEconomyFullPrice() : 0.0;
    double executiveTax = flight.getTaxBusinessBasicPrice() != null ? flight.getTaxBusinessBasicPrice() : 0.0;
    double executiveFullTax = flight.getTaxBusinessFullPrice() != null ? flight.getTaxBusinessFullPrice() : 0.0;

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
      new FlightFullResponse.TaxesInfo(
        standardTax,
        economicTax,
        favorableTax,
        executiveTax,
        executiveFullTax
      ),
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
