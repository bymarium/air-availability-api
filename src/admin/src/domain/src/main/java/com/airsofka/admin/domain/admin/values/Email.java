package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class Email implements IValueObject {
    private final String value;

    private Email(String value) {
        this.value = value;
        validate();
    }

    public static Email of(String value) {
        return new Email(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "Email");
        ValueValidator.validateStringNotBlank(value, "Email");
        ValueValidator.validateEmailFormat(value, "Email");
    }

    public String getValue() {
        return value;
    }
}
