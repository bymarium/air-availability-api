package com.airsofka.authentication.application.generatetoken;

import com.airsofka.shared.application.Request;

public class GenerateTokenRequest extends Request {
  private final String email;

  public GenerateTokenRequest(String aggregateId, String email) {
    super(aggregateId);
    this.email = email;
  }

  public String getEmail() {
    return email;
  }
}
