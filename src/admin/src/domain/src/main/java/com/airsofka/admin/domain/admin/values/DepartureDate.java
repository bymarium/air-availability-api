package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

import java.time.LocalDateTime;

public class DepartureDate implements IValueObject {
    private final LocalDateTime value;

    private DepartureDate(LocalDateTime value) {
        this.value = value;
        validate();
    }

    public static DepartureDate of(LocalDateTime value) {
        return new DepartureDate(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateDateNotNull(value, "DepartureDate");
        ValueValidator.validateDateNotEmpty(value, "DepartureDate");
    }

    public LocalDateTime getValue() {
        return value;
    }
}
