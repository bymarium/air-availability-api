package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.Identity;

public class PaymentId extends Identity {
  public PaymentId() {
    super();
  }

  private PaymentId(String value){
    super(value);
  }

  public static PaymentId of (String value){
    return new PaymentId(value);
  }
}
