package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

import java.util.List;
import java.util.Map;

public class Prices implements IValueObject {
    private final Double standardPrice;
    private final Double tax;
    private final List<PassengerPrice> passengerPrices;

    public Prices(double standardPrice) {
        this.standardPrice = standardPrice;
        this.tax = 0.2;
        this.passengerPrices = generatePrices();
        validate();
    }

    public static Prices of(double standardPrice) {
        return new Prices(standardPrice);
    }

    @Override
    public void validate() {
        Validator.validatePositive(standardPrice);
    }

    private List<PassengerPrice> generatePrices() {
        Map<String, Double> priceMultipliers = Map.of(
                "economyBasic", 1.0,
                "economyClassic", 1.1,
                "economyFull", 1.25,
                "businessBasic", 1.5,
                "businessFull", 2.0
        );

        return priceMultipliers.entrySet().stream()
                .map(entry -> createPassengerPrice(entry.getKey(), entry.getValue()))
                .toList();
    }

    private PassengerPrice createPassengerPrice(String type, double multiplier) {
        double finalPrice = standardPrice * multiplier;
        return PassengerPrice.of(type, finalPrice, tax * finalPrice, finalPrice * tax+finalPrice);
    }

    public Double getStandardPrice() {
        return standardPrice;
    }

    public Double getTax() {
        return tax;
    }

    public List<PassengerPrice> getPassengerPrices() {
        return passengerPrices;
    }


}
