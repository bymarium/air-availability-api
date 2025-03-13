package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.IValueObject;

import static utils.Validator.validatePositive;

public class Counter implements IValueObject {
  private final Integer value;

  private Counter(int value) {
    this.value = value;
  }

  @Override
  public void validate() {
    validatePositive(value);
  }

  public int getValue() {
    return value;
  }

  public static Counter of(int value){
    return new Counter(value);
  }
}
