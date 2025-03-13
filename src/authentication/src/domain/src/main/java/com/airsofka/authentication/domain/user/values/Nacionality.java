package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class Nacionality implements IValueObject {
  private final String value;

  private Nacionality(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Nacionality cannot be null or empty");
  }

  public String getValue() {
    return value;
  }

  public static Nacionality of(String value){
    return new Nacionality(value);
  }
}
