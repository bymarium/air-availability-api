package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import java.util.Arrays;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class MethodAuthentication implements IValueObject {
  private String value;

  private MethodAuthentication(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Method authentication cannot be null or empty");

    boolean isValid = Arrays.stream(MethodEnum.values())
      .anyMatch(type -> type.name().equals(this.value.toUpperCase()));

    if (!isValid) {
      throw new IllegalArgumentException("Invalid method authentication");
    }
  }

  public String getValue() {
    return value;
  }

  public static MethodAuthentication of(String value){
    return new MethodAuthentication(value);
  }
}
