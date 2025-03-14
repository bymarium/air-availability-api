package com.airsofka.authentication.application.modifyuser;

import com.airsofka.shared.application.Request;

public class ModifyUserRequest extends Request {
  private final String token;
  private final String fullName;
  private final String password;
  private final String phoneNumber;
  private final String nacionality;

  public ModifyUserRequest(String token, String fullName, String password, String phoneNumber, String nacionality) {
    super(null);
    this.token = token;
    this.fullName = fullName;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
  }

  public String getToken() {
    return token;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassword() {
    return password;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getNacionality() {
    return nacionality;
  }
}
