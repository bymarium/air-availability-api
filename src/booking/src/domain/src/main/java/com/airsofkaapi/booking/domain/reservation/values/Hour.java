package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

import java.time.LocalTime;

public class Hour implements IValueObject {
  private final LocalTime value;

  private Hour(LocalTime value) {
    this.value = value;
    validate();
  }

  public static Hour of(LocalTime value) {
    return new Hour(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Hour");
  }

  public LocalTime getValue() {
    return value;
  }
}
