package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateMinLength;
import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class PhoneNumber implements IValueObject {
  private String value;

  private PhoneNumber(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Phone number cannot be null or empty");
    validateMinLength(value, 10, "Phone number must be at least 10 characters");
  }

  public String getValue() {
    return value;
  }

  public static PhoneNumber of(String value){
    return new PhoneNumber(value);
  }
}
