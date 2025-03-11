package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateMinLength;
import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class DocumentID implements IValueObject {
  private final String value;

  private DocumentID(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Document ID cannot be null");
    validateMinLength(value, 8, "Document ID must be at least 8 characters");
  }

  public String getValue() {
    return value;
  }

  public static DocumentID of(String value){
    return new DocumentID(value);
  }
}
