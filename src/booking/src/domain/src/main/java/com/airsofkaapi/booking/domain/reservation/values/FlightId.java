package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.Identity;

public class FlightId extends Identity {
  public FlightId() {
    super();
  }

  private FlightId(String value){
    super(value);
  }

  public static FlightId of (String value){
    return new FlightId(value);
  }
}
