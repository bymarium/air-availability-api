package com.airsofkaapi.booking.domain.shared.dtos;

public class BillingAddressDto {
  private String addressOne;
  private String addressTwo;
  private String country;
  private String city;
  private String state;
  private Integer postalCode;
  private String phoneNumber;
  private String email;

  public String getAddressOne() {
    return addressOne;
  }

  public void setAddressOne(String addressOne) {
    this.addressOne = addressOne;
  }

  public String getAddressTwo() {
    return addressTwo;
  }

  public void setAddressTwo(String addressTwo) {
    this.addressTwo = addressTwo;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Integer getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Integer postalCode) {
    this.postalCode = postalCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
