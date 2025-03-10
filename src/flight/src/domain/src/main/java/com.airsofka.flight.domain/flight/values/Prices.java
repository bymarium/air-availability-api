package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Prices implements IValueObject {
    private double priceStandar;
    private double childPrice;
    private double infantPrice;

    public Prices(double adultPrice) {
        this.priceStandar = adultPrice;
        setPrices();
    }

    public static Prices of(double adultPrice) {
        Prices prices = new Prices(adultPrice);
        prices.setPrices();
        prices.validate();
        return prices;
    }

    @Override
    public void validate() {
        Validator.validatePositive(priceStandar);
        Validator.validatePositive(childPrice);
        Validator.validatePositive(infantPrice);
    }

    void setPrices() {
        this.childPrice = this.priceStandar * 0.75;
        this.infantPrice = this.priceStandar * 0.45;
    }

    public double getPriceStandar() {
        return priceStandar;
    }

    public void setPriceStandar(double priceStandar) {
        this.priceStandar = priceStandar;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public double getInfantPrice() {
        return infantPrice;
    }

    public void setInfantPrice(double infantPrice) {
        this.infantPrice = infantPrice;
    }

}
