package com.airsofkaapi.booking.domain.reservation.entities;

import com.airsofka.shared.domain.generic.Entity;
import com.airsofkaapi.booking.domain.reservation.values.Category;
import com.airsofkaapi.booking.domain.reservation.values.FlightId;
import com.airsofkaapi.booking.domain.reservation.values.Hour;
import com.airsofkaapi.booking.domain.reservation.values.Money;
import com.airsofkaapi.booking.domain.reservation.values.RelationalId;

public class Flight extends Entity<FlightId> {
  private RelationalId relationalId;
  private Money price;
  private Category category;
  private Hour startTime;
  private Hour endTime;

  public Flight(FlightId identity, RelationalId relationalId, Money price, Category category, Hour startTime, Hour endTime) {
    super(identity);
    this.relationalId = relationalId;
    this.price = price;
    this.category = category;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public Flight(RelationalId relationalId,Money price, Category category, Hour startTime, Hour endTime) {
    super(new FlightId());
    this.relationalId = relationalId;
    this.price = price;
    this.category = category;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  // region Getters and Setters

  public RelationalId getRelationalId() {
    return relationalId;
  }

  public void setRelationalId(RelationalId relationalId) {
    this.relationalId = relationalId;
  }

  public Money getPrice() {
    return price;
  }

  public void setPrice(Money price) {
    this.price = price;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Hour getStartTime() {
    return startTime;
  }

  public void setStartTime(Hour startTime) {
    this.startTime = startTime;
  }

  public Hour getEndTime() {
    return endTime;
  }

  public void setEndTime(Hour endTime) {
    this.endTime = endTime;
  }
  //endregion
}
