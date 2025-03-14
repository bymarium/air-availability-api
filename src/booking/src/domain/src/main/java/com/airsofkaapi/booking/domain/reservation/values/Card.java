package com.airsofkaapi.booking.domain.reservation.values;

import com.airsofka.shared.domain.generic.IValueObject;
import com.airsofka.shared.domain.utils.ReservationValidator;

public class Card implements IValueObject {
  private final String number;
  private final String holderName;
  private final String expirationDate;
  private final String countryIssue;

  private Card(String number, String holderName, String expirationDate, String countryIssue) {
    this.number = number;
    this.holderName = holderName;
    this.expirationDate = expirationDate;
    this.countryIssue = countryIssue;
    validate();
  }

  public static Card of(String number, String holderName, String expirationDate, String countryIssue) {
    return new Card(number, holderName, expirationDate, countryIssue);
  }

  @Override
  public void validate() {
    ReservationValidator.validateNotNull(number, "Number");
    ReservationValidator.validateNotNull(holderName, "Holder name");
    ReservationValidator.validateNotNull(expirationDate, "Expiration date");
    ReservationValidator.validateNotNull(countryIssue, "Country issue");
  }

  public String getNumber() {
    return number;
  }

  public String getHolderName() {
    return holderName;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public String getCountryIssue() {
    return countryIssue;
  }
}
