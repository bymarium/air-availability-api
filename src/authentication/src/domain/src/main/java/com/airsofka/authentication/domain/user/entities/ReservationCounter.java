package com.airsofka.authentication.domain.user.entities;

import com.airsofka.authentication.domain.user.values.ReservationCounterId;
import com.airsofka.authentication.domain.user.values.Counter;
import com.airsofka.shared.domain.generic.Entity;

public class ReservationCounter extends Entity<ReservationCounterId> {
  private Counter counter;

  public ReservationCounter(ReservationCounterId identity, Counter counter) {
    super(identity);
    this.counter = counter;
  }

  public ReservationCounter(Counter counter) {
    super(new ReservationCounterId());
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
