package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class FlightClass implements IValueObject {
    private final String value;

    private FlightClass(String value) {
        this.value = value;
        validate();
    }

    public static FlightClass of(String value) {
        return new FlightClass(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "FlightClass");
        ValueValidator.validateStringNotBlank(value, "FlightClass");
        ValueValidator.validateSpecialCharacters(value, "FlightClass");
    }

    public String getValue() {
        return value;
    }
}
