package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class PassengerPrice implements IValueObject {
    private final String type;
    private final Double price;
    private final Double tax;
    private final Double totalPrice;

    public PassengerPrice(String type, Double price, Double tax, Double totalPrice) {
        this.type = type;
        this.price = price;
        this.tax = tax;
        this.totalPrice = totalPrice;
    }

    public static PassengerPrice of(String type, Double price, Double tax,Double totalPrice) {
        PassengerPrice passengerPrice = new PassengerPrice(type, price, tax, totalPrice);
        passengerPrice.validate();
        return passengerPrice;
    }


    @Override
    public void validate() {
        Validator.validatePositive(price);
        Validator.validatePositive(tax);
    }

    public Double getPrice() {
        return price;
    }

    public Double getTax() {
        return tax;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getType() {
        return type;
    }
}
