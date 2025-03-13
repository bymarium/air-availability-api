package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class PaymentMethod implements IValueObject {
    private final String value;

    private PaymentMethod(String value) {
        this.value = value;
        validate();
    }

    public static PaymentMethod of(String value) {
        return new PaymentMethod(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "PaymentMethod");
        ValueValidator.validateStringNotBlank(value, "PaymentMethod");
        ValueValidator.validateSpecialCharacters(value, "PaymentMethod");
    }

    public String getValue() {
        return value;
    }
}
