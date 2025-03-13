package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateNotNull;

public class IsAuthenticated implements IValueObject {
  private boolean value;

  private IsAuthenticated(boolean value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateNotNull(value, "isAuthenticated cannot be null");
  }

  public boolean getValue() {
    return value;
  }

  public static IsAuthenticated of(boolean value){
    return new IsAuthenticated(value);
  }
}
