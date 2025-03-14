package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

import java.time.LocalDate;

public class BirthdayDate implements IValueObject {
  private final LocalDate value;

  private BirthdayDate(LocalDate value) {
    this.value = value;
    validate();
  }

  public static BirthdayDate of(LocalDate value) {
    return new BirthdayDate(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Birthday date");
    ReservationValidator.validateBirthdayDate(value, "Birthday date");
  }

  public LocalDate getValue() {
    return value;
  }
}
