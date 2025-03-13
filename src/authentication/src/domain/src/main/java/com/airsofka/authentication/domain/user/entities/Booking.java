package com.airsofka.authentication.domain.user.entities;

import com.airsofka.authentication.domain.user.values.BookingId;
import com.airsofka.shared.domain.generic.Entity;

public class Booking extends Entity<BookingId> {
  public Booking(BookingId identity) {
    super(identity);
  }
}
