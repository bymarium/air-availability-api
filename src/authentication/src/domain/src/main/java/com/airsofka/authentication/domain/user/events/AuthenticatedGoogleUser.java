package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class AuthenticatedGoogleUser extends DomainEvent {
  private String email;
  private String fullName;

  public AuthenticatedGoogleUser() {
    super(EventsEnum.AUTHENTICATED_GOOGLE_USER.name());
  }

  public AuthenticatedGoogleUser(String email, String fullName) {
    super(EventsEnum.AUTHENTICATED_GOOGLE_USER.name());
    this.email = email;
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
}
