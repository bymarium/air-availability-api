package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class DocumentNumber implements IValueObject {
  private final String value;

  private DocumentNumber(String value) {
    this.value = value;
    validate();
  }

  public static DocumentNumber of(String value) {
    return new DocumentNumber(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Document number");
    ReservationValidator.validateNotBlank(value, "Document number");
    ReservationValidator.validateColombianDocument(value, "Document number");
  }

  public String getValue() {
    return value;
  }
}
