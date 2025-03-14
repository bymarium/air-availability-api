package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class FlightNumber implements IValueObject {
    private final String value;

    private FlightNumber(String value) {
        this.value = value;
    }

    public static FlightNumber of(String value) {
        FlightNumber flightNumber = new FlightNumber(value);
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
