package com.airsofka.authentication.application.checkuserexists;

import com.airsofka.shared.application.Request;

public class CheckUserExistsRequest extends Request {
  private final String email;

  public CheckUserExistsRequest(String email) {
    super(null);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}
