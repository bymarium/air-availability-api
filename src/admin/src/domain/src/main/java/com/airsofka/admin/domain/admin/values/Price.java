package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class Price implements IValueObject {
    private final Double value;

    private Price(Double value) {
        this.value = value;
        validate();
    }

    public static Price of(Double value) {
        return new Price(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateNonNegative(value, "Income");
        ValueValidator.validateNotNull(value, "Income");
    }

    public Double getValue() {
        return value;
    }
}
