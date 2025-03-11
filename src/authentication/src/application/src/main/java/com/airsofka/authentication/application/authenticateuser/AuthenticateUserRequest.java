package com.airsofka.authentication.application.authenticateuser;

import com.airsofka.shared.application.Request;

public class AuthenticateUserRequest extends Request {
  private final String email;
  private final String password;

  public AuthenticateUserRequest(String aggregateId, String email, String password) {
    super(aggregateId);
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}
