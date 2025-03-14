package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class BillingAddress implements IValueObject {
  private final  String addressOne;
  private final  String addressTwo;
  private final  String country;
  private final  String city;
  private final  String state;
  private final  Integer postalCode;
  private final  String phoneNumber;
  private final  String email;

  private BillingAddress(String addressOne, String addressTwo, String country, String city, String state, Integer postalCode, String phoneNumber, String email) {
    this.addressOne = addressOne;
    this.addressTwo = addressTwo;
    this.country = country;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    this.phoneNumber = phoneNumber;
    this.email = email;
    validate();
  }

  public static BillingAddress of(String addressOne, String addressTwo, String country, String city, String state, Integer postalCode, String phoneNumber, String email) {
    return new BillingAddress(addressOne, addressTwo, country, city, state, postalCode, phoneNumber, email);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(addressOne, "Address one");
    ReservationValidator.validateNotBlank(addressOne, "Address one");

    ReservationValidator.validateNotNull(addressTwo, "Address two");

    ReservationValidator.validateNotNull(country, "Country");
    ReservationValidator.validateNotBlank(country, "Country");
    ReservationValidator.validateName(country, "Country");

    ReservationValidator.validateNotNull(city, "City");
    ReservationValidator.validateNotBlank(city, "City");
    ReservationValidator.validateName(city, "City");

    ReservationValidator.validateNotNull(state, "State");
    ReservationValidator.validateNotBlank(state, "State");
    ReservationValidator.validateName(state, "State");

    ReservationValidator.validateNotNull(postalCode, "Postal code");
    ReservationValidator.validatePositive(postalCode, "Postal code");
    ReservationValidator.validateIntegerInRange(postalCode, 100000, 999999, "Postal code");

    ReservationValidator.validateNotNull(phoneNumber, "Phone number");
    ReservationValidator.validateNotBlank(phoneNumber, "Phone number");

    ReservationValidator.validateNotNull(email, "Email");
    ReservationValidator.validateNotBlank(email, "Email");
    ReservationValidator.validateEmail(email, "Email");
  }

  public String getAddressOne() {
    return addressOne;
  }

  public String getAddressTwo() {
    return addressTwo;
  }

  public String getCountry() {
    return country;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public Integer getPostalCode() {
    return postalCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }
}
