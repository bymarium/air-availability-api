package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class MarkedAsFrequentUser  extends DomainEvent {
  public MarkedAsFrequentUser() {
    super(EventsEnum.MARKED_AS_FREQUENT_USER.name());
  }
}
