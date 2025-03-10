package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Prices implements IValueObject {
    private Double priceStandard;
    private Double childPrice;
    private Double infantPrice;
    private Double tax;

    public Prices(double adultPrice) {
        this.priceStandard = adultPrice;
        this.tax = 1.2;
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
        Validator.validatePositive(priceStandard);
        Validator.validatePositive(childPrice);
        Validator.validatePositive(infantPrice);
    }

    void setPrices() {
        this.priceStandard = this.priceStandard * this.tax;
        this.childPrice = this.priceStandard * 0.75 * this.tax;
        this.infantPrice = this.priceStandard * 0.45 * this.tax;
    }

    public double getPriceStandard() {
        return priceStandard;
    }

    public void setPriceStandard(double priceStandard) {
        this.priceStandard = priceStandard;
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

    public void setPriceStandard(Double priceStandard) {
        this.priceStandard = priceStandard;
    }

    public void setChildPrice(Double childPrice) {
        this.childPrice = childPrice;
    }

    public void setInfantPrice(Double infantPrice) {
        this.infantPrice = infantPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}
