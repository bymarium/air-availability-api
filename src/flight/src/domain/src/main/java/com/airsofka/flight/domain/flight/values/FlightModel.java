package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class FlightModel implements IValueObject {
    private final String value;

    private FlightModel(String value) {
        this.value = value;
    }

    public static FlightModel of(String value) {
        FlightModel flightNumber = new FlightModel(value);
        flightNumber.validate();

        return flightNumber;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public String getValue() {
        return value;
    }
}
