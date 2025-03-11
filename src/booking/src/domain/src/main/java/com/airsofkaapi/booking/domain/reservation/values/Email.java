package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Email implements IValueObject {
  private final String value;

  private Email(String value) {
    this.value = value;
    validate();
  }

  public static Email of(String value) {
    return new Email(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Email");
    ReservationValidator.validateNotBlank(value, "Email");
    ReservationValidator.validateEmail(value, "Email");
  }

  public String getValue() {
    return value;
  }
}
