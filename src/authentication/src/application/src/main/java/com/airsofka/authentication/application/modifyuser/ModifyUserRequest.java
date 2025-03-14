package com.airsofka.authentication.application.modifyuser;

import com.airsofka.shared.application.Request;

public class ModifyUserRequest extends Request {
  private final String token;
  private final String name;
  private final String password;
  private final String phoneNumber;
  private final String nacionality;

  public ModifyUserRequest(String token, String name, String password, String phoneNumber, String nacionality) {
    super(null);
    this.token = token;
    this.name = name;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
  }

  public String getToken() {
    return token;
  }

  public String getName() {
    return name;
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
