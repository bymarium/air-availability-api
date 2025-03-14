package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;

public class BookerName implements IValueObject {
    private final String value;

    private BookerName(String value) {
        this.value = value;
        validate();
    }

    public static BookerName of(String value) {
        return new BookerName(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateStringNotEmpty(value, "BookerName");
        ValueValidator.validateStringNotBlank(value, "BookerName");
        ValueValidator.validateSpecialCharacters(value, "BookerName");
    }

    public String getValue() {
        return value;
    }
}
