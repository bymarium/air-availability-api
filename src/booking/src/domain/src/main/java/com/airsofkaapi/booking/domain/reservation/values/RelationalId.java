package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class RelationalId implements IValueObject {
  private final String value;

  private RelationalId(String value) {
    this.value = value;
    validate();
  }

  public static RelationalId of(String value) {
    return new RelationalId(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "RelationalId");
    ReservationValidator.validateNotBlank(value, "RelationalId");
  }

  public String getValue() {
    return value;
  }
}
