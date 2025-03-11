package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class TotalSeats implements IValueObject {
    private final int value;

    private TotalSeats(int value) {
        this.value = value;
    }

    public static TotalSeats of(int value) {
        TotalSeats totalSeats = new TotalSeats(value);
        totalSeats.validate();
        return totalSeats;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public int getValue() {
        return value;
    }
}
