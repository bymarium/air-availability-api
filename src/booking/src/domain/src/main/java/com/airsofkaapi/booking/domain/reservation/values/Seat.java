package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Seat implements IValueObject {
  private final String value;

  private Seat(String value) {
    this.value = value;
    validate();
  }

  public static Seat of(String value) {
    return new Seat(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Seat");
    ReservationValidator.validateNotBlank(value, "Seat");
    ReservationValidator.validateAlphanumericCharacters(value, "Seat");
  }

  public String getValue() {
    return value;
  }
}
