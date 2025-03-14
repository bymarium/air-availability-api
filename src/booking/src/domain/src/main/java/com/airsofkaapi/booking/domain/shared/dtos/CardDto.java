package com.airsofkaapi.booking.domain.shared.dtos;

public class CardDto {
  private String number;
  private String holderName;
  private String expirationDate;
  private Integer cvv;
  private String countryIssue;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public Integer getCvv() {
    return cvv;
  }

  public void setCvv(Integer cvv) {
    this.cvv = cvv;
  }

  public String getCountryIssue() {
    return countryIssue;
  }

  public void setCountryIssue(String countryIssue) {
    this.countryIssue = countryIssue;
  }
}
