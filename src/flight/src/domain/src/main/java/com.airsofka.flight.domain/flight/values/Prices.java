package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Prices implements IValueObject {
    private Double standardPrice;
    private Double executivePrice;
    private Double fullPrice;
    private Double tax;

    public Prices(double adultPrice) {
        this.standardPrice = adultPrice;
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
        Validator.validatePositive(standardPrice);
        Validator.validatePositive(executivePrice);
        Validator.validatePositive(fullPrice);
    }

    void setPrices() {
        this.standardPrice = this.standardPrice * this.tax;
        this.executivePrice = this.standardPrice * 0.75 * this.tax;
        this.fullPrice = this.standardPrice * 0.45 * this.tax;
    }

    public double getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(double standardPrice) {
        this.standardPrice = standardPrice;
    }

    public double getExecutivePrice() {
        return executivePrice;
    }

    public void setExecutivePrice(double executivePrice) {
        this.executivePrice = executivePrice;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public void setPriceStandard(Double priceStandard) {
        this.standardPrice = priceStandard;
    }

    public void setChildPrice(Double childPrice) {
        this.executivePrice = childPrice;
    }

    public void setInfantPrice(Double infantPrice) {
        this.fullPrice = infantPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }
}
