package com.airsofka.flight.domain.flight.values;

import com.airsofka.shared.domain.generic.IValueObject;
import utils.Validator;

public class LocationSeat implements IValueObject {
    private final Integer row;
    private final String column;

    public LocationSeat(Integer row, String column) {
        this.row = row;
        this.column = column;
    }
    public static LocationSeat of(Integer row, String column) {
        LocationSeat rowSeat = new LocationSeat(row, column);
        rowSeat.validate();
        return rowSeat;
    }

    @Override
    public void validate() {
        Validator.validateNotNull(row);
        Validator.validateNotNull(column);
    }

    public Integer getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }
}
