package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class BookingCode implements IValueObject {
    private final String value;

    private BookingCode(String value) {
        this.value = value;
        validate();
    }

    public static BookingCode of(String value) {
        return new BookingCode(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "BookingCode");
        ValueValidator.validateStringNotBlank(value, "BookingCode");
        ValueValidator.validateSpecialCharacters(value, "BookingCode");
    }

    public String getValue() {
        return value;
    }
}
