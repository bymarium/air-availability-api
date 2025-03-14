package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.Identity;

public class ReservationCounterId extends Identity {
  public ReservationCounterId() {
    super();
  }

  public ReservationCounterId(String value) {
    super(value);
  }

  public static ReservationCounterId of(String value) {
    return new ReservationCounterId(value);
  }
}
