package com.airsofka.flight.domain.route.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class Duration implements IValueObject {
    private final Integer value;

    private Duration(Integer value) {
        this.value = value;
    }

    public static Duration of(Integer value) {
        Duration duration = new Duration(value);
        duration.validate();

        return duration;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public Integer getValue() {
        return value;
    }
}