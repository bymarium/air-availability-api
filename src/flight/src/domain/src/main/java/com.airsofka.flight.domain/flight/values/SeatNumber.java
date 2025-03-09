package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class SeatNumber implements IValueObject {
    private final String value;

    private SeatNumber(String value) {
        this.value = value;
    }

    public static SeatNumber of(String value) {
        SeatNumber seatNumber = new SeatNumber(value);
        seatNumber.validate();

        return seatNumber;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public String getValue() {
        return value;
    }
}
