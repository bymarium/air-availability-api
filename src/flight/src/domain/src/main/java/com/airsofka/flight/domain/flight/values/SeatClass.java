package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class SeatClass implements IValueObject {
    private final String value;

    private SeatClass(String value) {
        this.value = value;
    }

    public static SeatClass of(String value) {
        SeatClass seatClass = new SeatClass(value);
        seatClass.validate();

        return seatClass;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public String getValue() {
        return value;
    }
}
