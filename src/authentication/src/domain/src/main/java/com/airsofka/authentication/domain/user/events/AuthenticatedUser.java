package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class AuthenticatedUser extends DomainEvent {
  private String email;
  private String password;

  public AuthenticatedUser() {
    super(EventsEnum.AUTHENTICATED_USER.name());
  }

  public AuthenticatedUser(String email, String password) {
    super(EventsEnum.AUTHENTICATED_USER.name());
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
