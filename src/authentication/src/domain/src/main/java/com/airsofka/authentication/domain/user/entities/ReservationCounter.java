package com.airsofka.authentication.domain.user.entities;

import com.airsofka.authentication.domain.user.values.BookingId;
import com.airsofka.authentication.domain.user.values.Counter;
import com.airsofka.shared.domain.generic.Entity;

public class ReservationCounter extends Entity<BookingId> {
  private Counter counter;

  public ReservationCounter(BookingId identity, Counter counter) {
    super(identity);
    this.counter = counter;
  }

  public ReservationCounter(Counter counter) {
    super(new BookingId());
    this.counter = counter;
  }

  public void resetCounter() {
    counter = Counter.of(0);
  }

  public boolean checkCounter(int referenceCounter) {
    boolean isFrequent = this.counter.getValue() >= referenceCounter;
    return this.counter.getValue() >= referenceCounter;
  }

  public Counter getCounter() {
    return counter;
  }

  public void setCounter(Counter counter) {
    this.counter = counter;
  }
}
