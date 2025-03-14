package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class PaymentMethod implements IValueObject {
  private final String value;

  private PaymentMethod(String value) {
    this.value = value;
    validate();
  }

  public static PaymentMethod of(String value) {
    return new PaymentMethod(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Payment method");
    ReservationValidator.validateNotBlank(value, "Payment method");
    ReservationValidator.validatePaymentMethod(value, "Payment method");
  }

  public String getValue() {
    return value;
  }
}
