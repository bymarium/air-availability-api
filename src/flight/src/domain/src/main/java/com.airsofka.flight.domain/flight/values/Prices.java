package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Prices implements IValueObject {
    private double adultPrice;
    private double childPrice;
    private double infantPrice;

    public Prices(double adultPrice, double childPrice, double infantPrice) {
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.infantPrice = infantPrice;
    }

    public static Prices of(double adultPrice, double childPrice, double infantPrice) {
        Prices prices = new Prices(adultPrice, childPrice, infantPrice);
        prices.validate();

        return prices;
    }

    @Override
    public void validate() {
    Validator.validateNotNull(adultPrice);
    Validator.validateNotNull(childPrice);
    Validator.validateNotNull(infantPrice);
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
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
