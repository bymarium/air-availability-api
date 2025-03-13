package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class LoggedOutUser extends DomainEvent {
  public LoggedOutUser() {
    super(EventsEnum.LOGGED_OUT_USER.name());
  }
}
