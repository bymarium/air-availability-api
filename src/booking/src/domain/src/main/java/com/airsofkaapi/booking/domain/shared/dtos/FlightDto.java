package com.airsofkaapi.booking.domain.shared.dtos;

import java.time.LocalTime;

public class FlightDto {
  private String relationalId;
  private Double price;
  private String category;
  private LocalTime startTime;
  private LocalTime endTime;

  public String getRelationalId() {
    return relationalId;
  }

  public void setRelationalId(String relationalId) {
    this.relationalId = relationalId;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }
}
