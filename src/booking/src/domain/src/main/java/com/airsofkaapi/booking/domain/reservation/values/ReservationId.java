package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.Identity;

public class ReservationId extends Identity {
  public ReservationId() {
    super();
  }

  private ReservationId(String value){
    super(value);
  }

  public static ReservationId of (String value){
    return new ReservationId(value);
  }
}
