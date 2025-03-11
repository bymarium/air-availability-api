package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateMinLength;
import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class Password implements IValueObject {
  private final String value;

  private Password(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Password cannot be null");
    validateMinLength(value, 12, "Password must be at least 12 characters");
  }

  public String getValue() {
    return value;
  }

  public static Password of(String value){
    return new Password(value);
  }
}
