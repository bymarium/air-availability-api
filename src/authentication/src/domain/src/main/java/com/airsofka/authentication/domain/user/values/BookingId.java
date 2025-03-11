package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.Identity;

public class BookingId extends Identity {
  public BookingId() {
    super();
  }

  public BookingId(String value) {
    super(value);
  }

  public static BookingId of(String value) {
    return new BookingId(value);
  }
}
