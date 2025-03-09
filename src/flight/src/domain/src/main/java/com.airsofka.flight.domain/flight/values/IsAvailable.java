package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class IsAvailable implements IValueObject {
    private final boolean value;

    private IsAvailable(boolean value) {
        this.value = value;
    }

    public static IsAvailable of(boolean value) {
        IsAvailable isAvailable = new IsAvailable(value);
        isAvailable.validate();

        return isAvailable;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(value);
    }
    public boolean getValue() {
        return value;
    }
}
