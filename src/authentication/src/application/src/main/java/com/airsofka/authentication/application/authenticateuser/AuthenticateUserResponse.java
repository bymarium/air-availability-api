package com.airsofka.authentication.application.authenticateuser;

public class AuthenticateUserResponse {
  private final String email;
  private final Boolean isAuthenticated;
  private final String token;

  public AuthenticateUserResponse(String email, Boolean isAuthenticated, String token) {
    this.email = email;
    this.isAuthenticated = isAuthenticated;
    this.token = token;
  }

  public String getEmail() {
    return email;
  }

  public Boolean getIsAuthenticated() {
    return isAuthenticated;
  }

  public String getToken() {
    return token;
  }
}
