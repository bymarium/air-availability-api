package com.airsofkaapi.booking.domain.reservation.entities;

import com.airsofka.shared.domain.generic.Entity;
import com.airsofkaapi.booking.domain.reservation.values.BirthdayDate;
import com.airsofkaapi.booking.domain.reservation.values.DocumentNumber;
import com.airsofkaapi.booking.domain.reservation.values.DocumentType;
import com.airsofkaapi.booking.domain.reservation.values.Email;
import com.airsofkaapi.booking.domain.reservation.values.Gender;
import com.airsofkaapi.booking.domain.reservation.values.PassengerId;
import com.airsofkaapi.booking.domain.reservation.values.PassengerType;
import com.airsofkaapi.booking.domain.reservation.values.Phone;
import com.airsofkaapi.booking.domain.reservation.values.RegularName;
import com.airsofkaapi.booking.domain.reservation.values.Seat;

public class Passenger extends Entity<PassengerId> {
  private PassengerType type;
  private RegularName firstName;
  private RegularName lastName;
  private DocumentType documentType;
  private DocumentNumber documentNumber;
  private Gender gender;
  private BirthdayDate birthdayDate;
  private Email email;
  private Phone phone;
  private Seat originSeat;
  private Seat destinationSeat;

  public Passenger(PassengerId identity, PassengerType type, RegularName firstName, RegularName lastName, DocumentType documentType, DocumentNumber documentNumber, Gender gender, BirthdayDate birthdayDate, Email email, Phone phone, Seat originSeat, Seat destinationSeat) {
    super(identity);
    this.type = type;
    this.firstName = firstName;
    this.lastName = lastName;
    this.documentType = documentType;
    this.documentNumber = documentNumber;
    this.gender = gender;
    this.birthdayDate = birthdayDate;
    this.email = email;
    this.phone = phone;
    this.originSeat = originSeat;
    this.destinationSeat = destinationSeat;
  }

  public Passenger(PassengerType type, RegularName firstName, RegularName lastName, DocumentType documentType, DocumentNumber documentNumber, Gender gender, BirthdayDate birthdayDate, Email email, Phone phone, Seat originSeat, Seat destinationSeat) {
    super(new PassengerId());
    this.type = type;
    this.firstName = firstName;
    this.lastName = lastName;
    this.documentType = documentType;
    this.documentNumber = documentNumber;
    this.gender = gender;
    this.birthdayDate = birthdayDate;
    this.email = email;
    this.phone = phone;
    this.originSeat = originSeat;
    this.destinationSeat = destinationSeat;
  }

  // region Getters and Setters
  public PassengerType getType() {
    return type;
  }

  public void setType(PassengerType type) {
    this.type = type;
  }

  public RegularName getFirstName() {
    return firstName;
  }

  public void setFirstName(RegularName firstName) {
    this.firstName = firstName;
  }

  public RegularName getLastName() {
    return lastName;
  }

  public void setLastName(RegularName lastName) {
    this.lastName = lastName;
  }

  public DocumentType getDocumentType() {
    return documentType;
  }

  public void setDocumentType(DocumentType documentType) {
    this.documentType = documentType;
  }

  public DocumentNumber getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(DocumentNumber documentNumber) {
    this.documentNumber = documentNumber;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public BirthdayDate getBirthdayDate() {
    return birthdayDate;
  }

  public void setBirthdayDate(BirthdayDate birthdayDate) {
    this.birthdayDate = birthdayDate;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public Phone getPhone() {
    return phone;
  }

  public void setPhone(Phone phone) {
    this.phone = phone;
  }

  public Seat getOriginSeat() {
    return originSeat;
  }

  public void setOriginSeat(Seat originSeat) {
    this.originSeat = originSeat;
  }

  public Seat getDestinationSeat() {
    return destinationSeat;
  }

  public void setDestinationSeat(Seat destinationSeat) {
    this.destinationSeat = destinationSeat;
  }
  //endregion
}
