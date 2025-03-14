package com.airsofkaapi.booking.domain.shared.dtos;

import java.time.LocalDate;

public class PassengerDto {
  private String type;
  private String firstName;
  private String lastName;
  private String documentType;
  private String documentNumber;
  private String gender;
  private LocalDate birthdayDate;
  private String email;
  private String phone;
  private String originSeat;
  private String destinationSeat;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public LocalDate getBirthdayDate() {
    return birthdayDate;
  }

  public void setBirthdayDate(LocalDate birthdayDate) {
    this.birthdayDate = birthdayDate;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getOriginSeat() {
    return originSeat;
  }

  public void setOriginSeat(String originSeat) {
    this.originSeat = originSeat;
  }

  public String getDestinationSeat() {
    return destinationSeat;
  }

  public void setDestinationSeat(String destinationSeat) {
    this.destinationSeat = destinationSeat;
  }
}
