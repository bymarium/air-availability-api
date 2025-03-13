package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import java.util.Arrays;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class State implements IValueObject {
  private String value;

  private State(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "State cannot be null or empty");

    boolean isValid = Arrays.stream(StateEnum.values())
      .anyMatch(type -> type.name().equals(this.value.toUpperCase()));

    if (!isValid) {
      throw new IllegalArgumentException("Invalid state");
    }
  }

  public String getValue() {
    return value;
  }

  public static State of(String value){
    return new State(value);
  }
}