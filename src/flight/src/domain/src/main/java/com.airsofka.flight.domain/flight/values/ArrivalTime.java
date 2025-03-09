package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

import java.util.Date;

public class ArrivalTime implements IValueObject {
    private final Date value;

    private ArrivalTime(Date value) {
        this.value = value;
    }

    public static ArrivalTime of(Date value) {
        ArrivalTime arrivalTime = new ArrivalTime(value);
        arrivalTime.validate();

        return arrivalTime;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public Date getValue() {
        return value;
    }
}
