package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static com.airsofka.shared.domain.utils.ValidationUtils.validateNotNull;

public class IsFrequent implements IValueObject {
  private boolean value;

  private IsFrequent(boolean value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validateNotNull(value, "Is frequent cannot be null");
  }

  public boolean getValue() {
    return value;
  }

  public static IsFrequent of(boolean value){
    return new IsFrequent(value);
  }
}
