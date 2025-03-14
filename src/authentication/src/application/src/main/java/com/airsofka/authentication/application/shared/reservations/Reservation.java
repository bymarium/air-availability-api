package com.airsofka.authentication.application.shared.reservations;

public class Reservation {
  private String status;
  private String origin;
  private String destination;
  private String reservationCode;
  private String flightDate;
  private String departureTime;
  private String arrivalTime;
  private String flightDuration;
  private String reservedBy;
  private String email;
  private String flightClass;
  private String purchaseDate;
  private String paymentMethod;
  private Integer passengersCount;
  private Double passengersPrice;
  private Double totalPrice;

  public Reservation() {
  }

  public Reservation(String status, String origin, String destination, String reservationCode, String flightDate, String departureTime, String arrivalTime, String flightDuration, String reservedBy, String email, String flightClass, String purchaseDate, String paymentMethod, Integer passengersCount, Double passengersPrice, Double totalPrice) {
    this.status = status;
    this.origin = origin;
    this.destination = destination;
    this.reservationCode = reservationCode;
    this.flightDate = flightDate;
    this.departureTime = departureTime;
    this.arrivalTime = arrivalTime;
    this.flightDuration = flightDuration;
    this.reservedBy = reservedBy;
    this.email = email;
    this.flightClass = flightClass;
    this.purchaseDate = purchaseDate;
    this.paymentMethod = paymentMethod;
    this.passengersCount = passengersCount;
    this.passengersPrice = passengersPrice;
    this.totalPrice = totalPrice;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public String getReservationCode() {
    return reservationCode;
  }

  public void setReservationCode(String reservationCode) {
    this.reservationCode = reservationCode;
  }

  public String getFlightDate() {
    return flightDate;
  }

  public void setFlightDate(String flightDate) {
    this.flightDate = flightDate;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getFlightDuration() {
    return flightDuration;
  }

  public void setFlightDuration(String flightDuration) {
    this.flightDuration = flightDuration;
  }

  public String getReservedBy() {
    return reservedBy;
  }

  public void setReservedBy(String reservedBy) {
    this.reservedBy = reservedBy;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFlightClass() {
    return flightClass;
  }

  public void setFlightClass(String flightClass) {
    this.flightClass = flightClass;
  }

  public String getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(String purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Integer getPassengersCount() {
    return passengersCount;
  }

  public void setPassengersCount(Integer passengersCount) {
    this.passengersCount = passengersCount;
  }

  public Double getPassengersPrice() {
    return passengersPrice;
  }

  public void setPassengersPrice(Double passengersPrice) {
    this.passengersPrice = passengersPrice;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
