package com.airsofka.authentication.application.shared.users;

public class UserResponse {
  private final String id;
  private final String name;
  private final String email;
  private final String documentId;
  private final String phoneNumber;
  private final String nacionality;
  private final String methodAuthentication;
  private final String state;
  private final String role;
  private final Boolean isFrequent;
  private Boolean isAuthenticated;


  public UserResponse(String id, String name, String email, String documentId, String phoneNumber, String nacionality, String methodAuthentication, String state, String role, Boolean isFrequent, Boolean isAuthenticated) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.documentId = documentId;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
    this.methodAuthentication = methodAuthentication;
    this.state = state;
    this.role = role;
    this.isFrequent = isFrequent;
    this.isAuthenticated = isAuthenticated;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
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

  public String getMethodAuthentication() {
    return methodAuthentication;
  }

  public String getRole() {
    return role;
  }

  public Boolean getFrequent() {
    return isFrequent;
  }

  public String getState() {
    return state;
  }

  public Boolean getAuthenticated() {
    return isAuthenticated;
  }

  public void setAuthenticated(Boolean authenticated) {
    isAuthenticated = authenticated;
  }
}
