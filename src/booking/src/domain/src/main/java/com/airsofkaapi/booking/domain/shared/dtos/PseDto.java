package com.airsofkaapi.booking.domain.shared.dtos;

public class PseDto {
  private String holderName;
  private String email;

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
