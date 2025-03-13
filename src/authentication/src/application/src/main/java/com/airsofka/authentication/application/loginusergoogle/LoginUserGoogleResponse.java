package com.airsofka.authentication.application.loginusergoogle;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class LoginUserGoogleResponse {
  private String token;
  private OidcUser user;

  public LoginUserGoogleResponse(String token, OidcUser user) {
    this.token = token;
    this.user = user;
  }

  public String getToken() {
    return token;
  }

  public OidcUser getUser() {
    return user;
  }
}
