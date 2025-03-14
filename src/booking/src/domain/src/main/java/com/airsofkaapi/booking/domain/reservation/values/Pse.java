package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Pse implements IValueObject {
  private final String holderName;
  private final String email;

  private Pse(String holderName, String email) {
    this.holderName = holderName;
    this.email = email;
    validate();
  }

  public static Pse of(String holderName, String email) {
    return new Pse(holderName, email);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(holderName, "Holder name");

    ReservationValidator.validateNotNull(email, "Email");
  }

  public String getHolderName() {
    return holderName;
  }

  public String getEmail() {
    return email;
  }
}
