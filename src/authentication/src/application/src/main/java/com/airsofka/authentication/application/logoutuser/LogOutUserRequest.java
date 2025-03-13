package com.airsofka.authentication.application.logoutuser;

import com.airsofka.shared.application.Request;

public class LogOutUserRequest extends Request {
  private final String token;

  protected LogOutUserRequest(String aggregateId, String token) {
    super(aggregateId);
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
