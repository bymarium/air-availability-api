package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreationDate implements IValueObject {
    private final LocalDate value;

    private CreationDate(LocalDate value) {
        this.value = value;
        validate();
    }

    public static CreationDate of(LocalDate value) {
        return new CreationDate(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateDateNotNull(value, "CreationDate");
        ValueValidator.validateDateNotEmpty(value, "CreationDate");
    }

    public LocalDate getValue() {
        return value;
    }
}
