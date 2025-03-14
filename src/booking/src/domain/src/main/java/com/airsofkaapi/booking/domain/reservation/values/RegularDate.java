package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

import java.time.LocalDate;

public class RegularDate implements IValueObject {
  private final LocalDate value;

  private RegularDate(LocalDate value) {
    this.value = value;
    validate();
  }

  public static RegularDate of(LocalDate value) {
    return new RegularDate(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Date");
  }

  public LocalDate getValue() {
    return value;
  }
}
