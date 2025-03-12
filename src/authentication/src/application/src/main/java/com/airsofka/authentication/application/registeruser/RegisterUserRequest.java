package com.airsofka.authentication.application.registeruser;

import com.airsofka.shared.application.Request;

public class RegisterUserRequest extends Request {

  private final String name;
  private final String email;
  private final String password;

  private final String documentId;
  private final String phoneNumber;
  private final String nacionality;

  public RegisterUserRequest(String aggregateId, String name, String email, String password, String documentId, String phoneNumber, String nacionality) {
    super(aggregateId);
    this.name = name;
    this.email = email;
    this.password = password;
    this.documentId = documentId;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getDocumentId() {
    return documentId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getNacionality() {
    return nacionality;
  }

}
