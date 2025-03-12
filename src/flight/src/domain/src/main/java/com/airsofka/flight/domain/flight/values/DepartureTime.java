package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

import java.util.Date;

public class DepartureTime implements IValueObject {
    private final Date value;

    private DepartureTime(Date value) {
        this.value = value;
    }

    public static DepartureTime of(Date value) {
        DepartureTime departureTime = new DepartureTime(value);
        departureTime.validate();

        return departureTime;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public Date getValue() {
        return value;
    }
}
