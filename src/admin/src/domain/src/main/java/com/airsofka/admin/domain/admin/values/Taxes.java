package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class Taxes implements IValueObject {
    private final Double value;

    private Taxes(Double value) {
        this.value = value;
        validate();
    }

    public static Taxes of(Double value) {
        return new Taxes(value);
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
