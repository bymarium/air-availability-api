package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.Identity;

public class PassengerId extends Identity {
  public PassengerId() {
    super();
  }

  private PassengerId(String value){
    super(value);
  }

  public static PassengerId of (String value){
    return new PassengerId(value);
  }
}
