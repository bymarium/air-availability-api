package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class State implements IValueObject {
  private final String value;

  private State(String value) {
    this.value = value;
    validate();
  }

  public static State of(String value) {
    return new State(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "State");
    ReservationValidator.validateNotBlank(value, "State");
    ReservationValidator.validateState(value, "State");
  }

  public String getValue() {
    return value;
  }
}
