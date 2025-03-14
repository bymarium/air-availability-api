package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class PassengerType implements IValueObject {
  private final String value;

  private PassengerType(String value) {
    this.value = value;
    validate();
  }

  public static PassengerType of(String value) {
    return new PassengerType(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Passenger type");
    ReservationValidator.validateNotBlank(value, "Passenger type");
    ReservationValidator.validatePassengerType(value, "Passenger type");
  }

  public String getValue() {
    return value;
  }
}
