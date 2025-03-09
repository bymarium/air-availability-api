package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class PriceSeat implements IValueObject {
    private final double value;

    private PriceSeat(double value) {
        this.value = value;
    }

    public static PriceSeat of(double value) {
        PriceSeat priceSeat = new PriceSeat(value);
        priceSeat.validate();

        return priceSeat;
    }

    @Override
    public void validate() {
        Validator.validatePositive(value);
    }
    public double getValue() {
        return value;
    }
}
