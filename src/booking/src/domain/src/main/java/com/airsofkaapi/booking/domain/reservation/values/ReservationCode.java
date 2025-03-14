package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class ReservationCode implements IValueObject {
  private final String value;

  private ReservationCode(String value) {
    this.value = value;
    validate();
  }

  public static ReservationCode of(String value) {
    return new ReservationCode(value);
  }
  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Reservation code");
    ReservationValidator.validateNotBlank(value, "Reservation code");
    ReservationValidator.validateAlphanumericCharacters(value, "Reservation code");
  }

  public String getValue() {
    return value;
  }
}
