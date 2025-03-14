package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Money implements IValueObject {
  private final Double value;

  private Money(Double value) {
    this.value = value;
    validate();
  }

  public static Money of(Double value) {
    return new Money(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Money");
    ReservationValidator.validateMoney(value, "Money");
  }

  public Double getValue() {
    return value;
  }
}
