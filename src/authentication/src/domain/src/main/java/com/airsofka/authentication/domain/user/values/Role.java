package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import java.util.Arrays;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateString;

public class Role implements IValueObject {
  private String value;

  private Role(String value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateString(value, "Role cannot be null or empty");

    boolean isValid = Arrays.stream(RoleEnum.values())
      .anyMatch(type -> type.name().equals(this.value.toUpperCase()));

    if (!isValid) {
      throw new IllegalArgumentException("Invalid role");
    }
  }

  public String getValue() {
    return value;
  }

  public static Role of(String value){
    return new Role(value);
  }
}
