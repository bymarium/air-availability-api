package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class ModifiedUser  extends DomainEvent {
  private String fullName;
  private String email;
  private String password;
  private String documentId;
  private String phoneNumber;
  private String nacionality;

  public ModifiedUser() {
    super(EventsEnum.MODIFIED_USER.name());
  }

  public ModifiedUser(String fullName, String email, String password, String documentId, String phoneNumber, String nacionality) {
    super(EventsEnum.MODIFIED_USER.name());
    this.fullName = fullName;
    this.email = email;
    this.password = password;
    this.documentId = documentId;
    this.phoneNumber = phoneNumber;
    this.nacionality = nacionality;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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
}
