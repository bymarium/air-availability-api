package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Phone implements IValueObject {
  private final String value;

  private Phone(String value) {
    this.value = value;
    validate();
  }

  public static Phone of(String value) {
    return new Phone(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Phone number");
    ReservationValidator.validateNotBlank(value, "Phone number");
  }

  public String getValue() {
    return value;
  }
}
