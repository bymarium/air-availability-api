package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class Name implements IValueObject {
  private final String value;

  private Name(String value) {
    this.value = value;
    validate();
  }

  @Override
  public void validate() {
    validateString(value, "Name cannot be null");
  }

  public String getValue() {
    return value;
  }

  public static Name of(String value){
    return new Name(value);
  }
}
