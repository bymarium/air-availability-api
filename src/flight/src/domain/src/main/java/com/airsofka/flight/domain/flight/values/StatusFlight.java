package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class StatusFlight implements IValueObject {
    private final String value;

    private StatusFlight(String value) {
        this.value = value;
    }

    public static StatusFlight of(String value) {
        StatusFlight statusFlight = new StatusFlight(value);
        statusFlight.validate();

        return statusFlight;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }

    public String getValue() {
        return value;
    }
}
