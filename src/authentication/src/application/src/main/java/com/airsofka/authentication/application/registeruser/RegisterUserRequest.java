package com.airsofka.authentication.application.registeruser;

import com.airsofka.shared.application.Request;

public class RegisterUserRequest extends Request {

  public RegisterUserRequest(String aggregateId) {
    super(aggregateId);
  }
}
