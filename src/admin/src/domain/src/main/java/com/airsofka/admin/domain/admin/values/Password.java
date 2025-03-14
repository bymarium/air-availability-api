package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class Password implements IValueObject {
    private final String value;

    private Password(String value) {
        this.value = value;
        validate();
    }

    public static Password of(String value) {
        return new Password(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "Password");
        ValueValidator.validateStringNotBlank(value, "Password");
        ValueValidator.validatePasswordFormat(value, "Password");
    }

    public String getValue() {
        return value;
    }
}
