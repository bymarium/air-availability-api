package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Gender implements IValueObject {
  private final String value;

  private Gender(String value) {
    this.value = value;
    validate();
  }

  public static Gender of(String value) {
    return new Gender(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Gender");
    ReservationValidator.validateNotBlank(value, "Gender");
  }

  public String getValue() {
    return value;
  }
}
