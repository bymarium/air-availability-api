package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

import java.time.LocalDate;

public class ArrivalDate implements IValueObject {
    private final LocalDate value;

    private ArrivalDate(LocalDate value) {
        this.value = value;
        validate();
    }

    public static ArrivalDate of(LocalDate value) {
        return new ArrivalDate(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateDateNotNull(value, "ArrivalDate");
        ValueValidator.validateDateNotEmpty(value, "ArrivalDate");
    }

    public LocalDate getValue() {
        return value;
    }
}
