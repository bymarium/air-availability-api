package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class DocumentType implements IValueObject {
  private final String value;

  private DocumentType(String value) {
    this.value = value;
    validate();
  }

  public static DocumentType of(String value) {
    return new DocumentType(value);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(value, "Document type");
    ReservationValidator.validateNotBlank(value, "Document type");

  }

  public String getValue() {
    return value;
  }
}
