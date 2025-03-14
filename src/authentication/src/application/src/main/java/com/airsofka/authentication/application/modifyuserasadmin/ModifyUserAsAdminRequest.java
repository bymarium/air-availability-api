package com.airsofka.authentication.application.modifyuserasadmin;

import com.airsofka.shared.application.Request;

public class ModifyUserAsAdminRequest extends Request {
  private final String originalEmail;
  private final String name;
  private final String email;
  private final String password;
  private final String documentId;
  private final String phoneNumber;
  private final String nacionality;

  public ModifyUserAsAdminRequest(String originalEmail, String name, String email, String password, String documentId, String phoneNumber, String nacionality) {
    super(null);
    this.originalEmail = originalEmail;
    this.name = name;
    this.email = email;
    this.password = password;
    this.documentId = documentId;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
  }

  public String getOriginalEmail() {
    return originalEmail;
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
