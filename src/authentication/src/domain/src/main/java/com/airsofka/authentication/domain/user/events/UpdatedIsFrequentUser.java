package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class UpdatedIsFrequentUser extends DomainEvent {
  private Integer counter;
  private Integer counterFrequent;

  public UpdatedIsFrequentUser() {
    super(EventsEnum.MARKED_AS_FREQUENT_USER.name());
  }

  public UpdatedIsFrequentUser(Integer counter, Integer counterFrequent) {
    super(EventsEnum.MARKED_AS_FREQUENT_USER.name());
    this.counter = counter;
    this.counterFrequent = counterFrequent;
  }

  public Integer getCounter() {
    return counter;
  }

  public void setCounter(Integer counter) {
    this.counter = counter;
  }

  public Integer getCounterFrequent() {
    return counterFrequent;
  }

  public void setCounterFrequent(Integer counterFrequent) {
    this.counterFrequent = counterFrequent;
  }
}
