package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class State implements IValueObject {
    private final String value;

    private State(String value) {
        this.value = value;
        validate();
    }

    public static State of(String value) {
        return new State(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "State");
        ValueValidator.validateStringNotBlank(value, "State");
        ValueValidator.validateSpecialCharacters(value, "State");
    }

    public String getValue() {
        return value;
    }
}
