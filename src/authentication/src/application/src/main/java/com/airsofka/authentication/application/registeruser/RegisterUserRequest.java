package com.airsofka.authentication.application.registeruser;

import com.airsofka.shared.application.Request;

public class RegisterUserRequest extends Request {

  private String name;
  private String email;
  private String password;

  private String documentId;
  private String phoneNumber;
  private String nacionality;
  private String methodAuthentication;

  public RegisterUserRequest(String aggregateId, String name, String email, String password, String documentId, String phoneNumber, String nacionality, String methodAuthentication) {
    super(aggregateId);
    this.name = name;
    this.email = email;
    this.password = password;
    this.documentId = documentId;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
    this.methodAuthentication = methodAuthentication;
  }

  public RegisterUserRequest(String aggregateId, String name, String email) {
    super(aggregateId);
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getNacionality() {
    return nacionality;
  }

  public void setNacionality(String nacionality) {
    this.nacionality = nacionality;
  }

  public String getMethodAuthentication() {
    return methodAuthentication;
  }

  public void setMethodAuthentication(String methodAuthentication) {
    this.methodAuthentication = methodAuthentication;
  }



}
