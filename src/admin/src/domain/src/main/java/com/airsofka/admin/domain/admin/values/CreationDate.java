package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

import java.time.LocalDateTime;

public class CreationDate implements IValueObject {
    private final LocalDateTime value;

    private CreationDate(LocalDateTime value) {
        this.value = value;
        validate();
    }

    public static CreationDate of(LocalDateTime value) {
        return new CreationDate(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateDateNotNull(value, "CreationDate");
        ValueValidator.validateDateNotEmpty(value, "CreationDate");
    }

    public LocalDateTime getValue() {
        return value;
    }
}
