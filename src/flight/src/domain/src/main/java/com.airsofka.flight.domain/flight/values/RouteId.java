package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class RouteId implements IValueObject {
    private final String value;

    private RouteId(String value) {
        this.value = value;
    }

    public static RouteId of(String value) {
        return new RouteId(value);
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public String getValue() {
        return value;
    }
}
