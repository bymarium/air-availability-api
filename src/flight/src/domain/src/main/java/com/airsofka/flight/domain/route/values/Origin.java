package com.airsofka.flight.domain.route.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Origin implements IValueObject {
    private final String value;

    private Origin(String value) {
        this.value = value;
    }

    public static Origin of(String value) {
        Origin origin = new Origin(value);
        origin.validate();

        return origin;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public String getValue() {
        return value;
    }
}