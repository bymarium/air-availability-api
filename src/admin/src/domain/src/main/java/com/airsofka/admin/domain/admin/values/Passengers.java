package com.airsofka.admin.domain.admin.values;

import com.airsofka.admin.domain.admin.utils.ValueValidator;
import com.airsofka.shared.domain.generic.IValueObject;
import java.util.List;

public class Passengers implements IValueObject {
    private final List value;

    private Passengers(List value) {
        this.value = value;
        validate();
    }

    public static Passengers of(List value) {
        return new Passengers(value);
    }

    @Override
    public void validate() {
        ValueValidator.validateListNotEmpty(value, "Passengers");
    }

    public List getValue() {
        return value;
    }
}
