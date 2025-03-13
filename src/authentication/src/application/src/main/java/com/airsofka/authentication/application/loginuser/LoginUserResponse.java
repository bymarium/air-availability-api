package com.airsofka.authentication.application.loginuser;

public class LoginUserResponse {
  private final String token;

  public LoginUserResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }
}
