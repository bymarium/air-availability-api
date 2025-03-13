package com.airsofka.authentication.application.decodetoken;

import com.airsofka.shared.application.Request;

public class DecodeTokenRequest extends Request {
  private final String token;

  public DecodeTokenRequest(String aggregateId, String token) {
    super(aggregateId);
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
