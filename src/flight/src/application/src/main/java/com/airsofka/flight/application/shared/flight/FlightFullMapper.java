package com.airsofka.flight.application.shared.flight;

import com.airsofka.flight.application.shared.route.RouteResponse;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlightFullMapper {

  public static FlightFullResponse mapToResponse(FlightListResponse flight, RouteResponse route) {
    String duration = calculateDuration(flight.getDepartureTime(), flight.getArrivalTime());
    String operatingAirline = "Copa Airlines";

    double standardPrice = roundToTwoDecimalPlaces(flight.getEconomyBasicPrice() != null ? flight.getEconomyBasicPrice() : 0.0);
    double economicPrice = roundToTwoDecimalPlaces(flight.getEconomyClassicPrice() != null ? flight.getEconomyClassicPrice() : 0.0);
    double favorablePrice = roundToTwoDecimalPlaces(flight.getEconomyFullPrice() != null ? flight.getEconomyFullPrice() : 0.0);
    double executivePrice = roundToTwoDecimalPlaces(flight.getBusinessBasicPrice() != null ? flight.getBusinessBasicPrice() : 0.0);
    double executiveFullPrice = roundToTwoDecimalPlaces(flight.getBusinessFullPrice() != null ? flight.getBusinessFullPrice() : 0.0);

    double standardTax = roundToTwoDecimalPlaces(flight.getTaxEconomyBasicPrice() != null ? flight.getTaxEconomyBasicPrice() : 0.0);
    double economicTax = roundToTwoDecimalPlaces(flight.getTaxEconomyClassicPrice() != null ? flight.getTaxEconomyClassicPrice() : 0.0);
    double favorableTax = roundToTwoDecimalPlaces(flight.getTaxEconomyFullPrice() != null ? flight.getTaxEconomyFullPrice() : 0.0);
    double executiveTax = roundToTwoDecimalPlaces(flight.getTaxBusinessBasicPrice() != null ? flight.getTaxBusinessBasicPrice() : 0.0);
    double executiveFullTax = roundToTwoDecimalPlaces(flight.getTaxBusinessFullPrice() != null ? flight.getTaxBusinessFullPrice() : 0.0);

    double standardTotalPrice = roundToTwoDecimalPlaces(flight.getTotalPriceEconomyBasicPrice() != null ? flight.getTotalPriceEconomyBasicPrice() : 0.0);
    double economicTotalPrice = roundToTwoDecimalPlaces(flight.getTotalPriceEconomyClassicPrice() != null ? flight.getTotalPriceEconomyClassicPrice() : 0.0);
    double favorableTotalPrice = roundToTwoDecimalPlaces(flight.getTotalPriceEconomyFullPrice() != null ? flight.getTotalPriceEconomyFullPrice() : 0.0);
    double executiveTotal = roundToTwoDecimalPlaces(flight.getTotalPriceBusinessBasicPrice() != null ? flight.getTotalPriceBusinessBasicPrice() : 0.0);
    double executiveFullTotal = roundToTwoDecimalPlaces(flight.getTotalPriceBusinessFullPrice() != null ? flight.getTotalPriceBusinessFullPrice() : 0.0);

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
      ),
      new FlightFullResponse.TotalPricesInfo(
        standardTotalPrice,
        economicTotalPrice,
        favorableTotalPrice,
        executiveTotal,
        executiveFullTotal
      )
    );
  }

  private static String calculateDuration(Date departure, Date arrival) {
    long diffMillis = arrival.getTime() - departure.getTime();
    long hours = TimeUnit.MILLISECONDS.toHours(diffMillis);
    long minutes = TimeUnit.MILLISECONDS.toMinutes(diffMillis) % 60;
    return String.format("%d:%02d", hours, minutes);
  }

  private static double roundToTwoDecimalPlaces(double value) {
    return Math.round(value * 100.0) / 100.0;
  }
}