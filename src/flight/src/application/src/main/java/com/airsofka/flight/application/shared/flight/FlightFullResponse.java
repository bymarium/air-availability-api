package com.airsofka.flight.application.shared.flight;

import lombok.Getter;

@Getter
public class FlightFullResponse {
  private final String flightId;
  private final String flightNumber;
  private final String aircraftModel;
  private final String duration;
  private final String operatingAirline;
  private final String origin;
  private final String destination;
  private final String departureTime;
  private final String arrivalTime;
  private final TaxesInfo tax;
  private final PricesInfo prices;
  private final TotalPricesInfo totalPricesInfo;

  public FlightFullResponse(String flightId, String flightNumber, String aircraftModel, String duration, String operatingAirline, String origin, String destination, String departureTime, String arrivalTime, TaxesInfo tax, PricesInfo prices, TotalPricesInfo totalPricesInfo) {
    this.flightId = flightId;
    this.flightNumber = flightNumber;
    this.aircraftModel = aircraftModel;
    this.duration = duration;
    this.operatingAirline = operatingAirline;
    this.origin = origin;
    this.destination = destination;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.tax = tax;
    this.prices = prices;
    this.totalPricesInfo = totalPricesInfo;
  }

  @Getter
  public static class PricesInfo {
    private final double standardPrice;
    private final double economicPrice;
    private final double favorablePrice;
    private final double executivePrice;
    private final double executiveFullPrice;

    public PricesInfo(double standardPrice, double economicPrice, double favorablePrice, double executivePrice, double executiveFullPrice) {
      this.standardPrice = standardPrice;
      this.economicPrice = economicPrice;
      this.favorablePrice = favorablePrice;
      this.executivePrice = executivePrice;
      this.executiveFullPrice = executiveFullPrice;
    }
  }

  @Getter
  public static class TaxesInfo{
    private final double standardTax;
    private final double economicTax;
    private final double favorableTax;
    private final double executiveTax;
    private final double executiveFullTax;

    public TaxesInfo(double standardTax, double economicTax, double favorableTax, double executiveTax, double executiveFullTax) {
      this.standardTax = standardTax;
      this.economicTax = economicTax;
      this.favorableTax = favorableTax;
      this.executiveTax = executiveTax;
      this.executiveFullTax = executiveFullTax;
    }
  }

  @Getter
  public static class TotalPricesInfo{
    private final double standardPriceTotal;
    private final double economicPriceTotal;
    private final double favorablePriceTotal;
    private final double executiveTotalPrice;
    private final double executiveFullTotalPrice;

    public TotalPricesInfo(double standardPriceTotal, double economicPriceTotal, double favorablePriceTotal, double executiveTotalPrice, double executiveFullTotalPrice) {
      this.standardPriceTotal = standardPriceTotal;
      this.economicPriceTotal = economicPriceTotal;
      this.favorablePriceTotal = favorablePriceTotal;
      this.executiveTotalPrice = executiveTotalPrice;
      this.executiveFullTotalPrice = executiveFullTotalPrice;
    }
  }
}
