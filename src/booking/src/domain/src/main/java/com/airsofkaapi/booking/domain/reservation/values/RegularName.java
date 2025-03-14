package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class RegularName implements IValueObject {
  private final String value;

  private RegularName(String value) {
    this.value = value;
    validate();
  }

  public static RegularName of(String value) {
    return new RegularName(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Name");
    ReservationValidator.validateNotBlank(value, "Name");
    ReservationValidator.validateName(value, "Name");
  }

  public String getValue() {
    return value;
  }
}
