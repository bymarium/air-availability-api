package com.airsofka.flight.domain.route.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Destination implements IValueObject {
    private final String value;

    private Destination(String value) {
        this.value = value;
    }

    public static Destination of(String value) {
        Destination destination = new Destination(value);
        destination.validate();

        return destination;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public String getValue() {
        return value;
    }
}
