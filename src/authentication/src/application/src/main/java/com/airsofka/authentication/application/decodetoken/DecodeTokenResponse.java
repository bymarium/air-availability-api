package com.airsofka.authentication.application.decodetoken;

public class DecodeTokenResponse {
  private final String id;
  private final String email;
  private final String role;
  private final Boolean isFrequent;

  public DecodeTokenResponse(String id, String email, String role, Boolean isFrequent) {
    this.id = id;
    this.email = email;
    this.role = role;
    this.isFrequent = isFrequent;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getRole() {
    return role;
  }

  public Boolean getFrequent() {
    return isFrequent;
  }
}
