package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Category implements IValueObject {
  private final String value;

  private Category(String value) {
    this.value = value;
    validate();
  }

  public static Category of(String value) {
    return new Category(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Category");
    ReservationValidator.validateNotBlank(value, "Category");
  }

  public String getValue() {
    return value;
  }
}
