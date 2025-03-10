package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class Email implements IValueObject {
  private final String value;

  private Email(String value) {
    this.value = value;
    validate();
  }

  @Override
  public void validate() {
    validateString(value, "Email cannot be null");
  }

  public String getValue() {
    return value;
  }

  public static Email of(String value) {
    return new Email(value);
  }
}