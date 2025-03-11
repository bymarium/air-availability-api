package com.airsofkaapi.booking.application.shared.reservation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservationResponse {
  private final String reservationId;
  private final String state;
  private final LocalDate departureDate;
  private final LocalDate arrivalDate;
  private final String origin;
  private final String destination;
  private final String reservationCode;
  private final LocalDate creationDate;
  private final Flight originFlight;
  private final Flight destinationFlight;
  private final List<Passenger> passengers;
  private final Payment payment;

  public ReservationResponse(String reservationId, String state, LocalDate departureDate, LocalDate arrivalDate, String origin, String destination, String reservationCode, LocalDate creationDate, Flight originFlight, Flight destinationFlight, List<Passenger> passengers, Payment payment) {
    this.reservationId = reservationId;
    this.state = state;
    this.departureDate = departureDate;
    this.arrivalDate = arrivalDate;
    this.origin = origin;
    this.destination = destination;
    this.reservationCode = reservationCode;
    this.creationDate = creationDate;
    this.originFlight = originFlight;
    this.destinationFlight = destinationFlight;
    this.passengers = passengers;
    this.payment = payment;
  }

  public String getReservationId() {
    return reservationId;
  }

  public String getState() {
    return state;
  }

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public LocalDate getArrivalDate() {
    return arrivalDate;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public String getReservationCode() {
    return reservationCode;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public Flight getOriginFlight() {
    return originFlight;
  }

  public Flight getDestinationFlight() {
    return destinationFlight;
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public Payment getPayment() {
    return payment;
  }

  public static class Flight {
    private final String id;
    private final Double price;
    private final String category;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Flight(String id, Double price, String category, LocalTime startTime, LocalTime endTime) {
      this.id = id;
      this.price = price;
      this.category = category;
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public String getId() {
      return id;
    }

    public Double getPrice() {
      return price;
    }

    public String getCategory() {
      return category;
    }

    public LocalTime getStartTime() {
      return startTime;
    }

    public LocalTime getEndTime() {
      return endTime;
    }
  }

  public static class Passenger {
    private final String id;
    private final String type;
    private final String firstName;
    private final String lastName;
    private final String documentType;
    private final String documentNumber;
    private final String gender;
    private final LocalDate birthdayDate;
    private final String email;
    private final String phone;
    private final String originSeat;
    private final String destinationSeat;

    public Passenger(String id, String type, String firstName, String lastName, String documentType, String documentNumber, String gender, LocalDate birthdayDate, String email, String phone, String originSeat, String destinationSeat) {
      this.id = id;
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

    public String getId() {
      return id;
    }

    public String getType() {
      return type;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public String getDocumentType() {
      return documentType;
    }

    public String getDocumentNumber() {
      return documentNumber;
    }

    public String getGender() {
      return gender;
    }

    public LocalDate getBirthdayDate() {
      return birthdayDate;
    }

    public String getEmail() {
      return email;
    }

    public String getPhone() {
      return phone;
    }

    public String getOriginSeat() {
      return originSeat;
    }

    public String getDestinationSeat() {
      return destinationSeat;
    }
  }

  public static class BillingAddress {
    private final  String addressOne;
    private final  String addressTwo;
    private final  String country;
    private final  String city;
    private final  String state;
    private final  Integer postalCode;
    private final  String phoneNumber;
    private final  String email;

    public BillingAddress(String addressOne, String addressTwo, String country, String city, String state, Integer postalCode, String phoneNumber, String email) {
      this.addressOne = addressOne;
      this.addressTwo = addressTwo;
      this.country = country;
      this.city = city;
      this.state = state;
      this.postalCode = postalCode;
      this.phoneNumber = phoneNumber;
      this.email = email;
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

  public static class Pse {
    private final String holderName;
    private final String email;

    public Pse(String holderName, String email) {
      this.holderName = holderName;
      this.email = email;
    }

    public String getHolderName() {
      return holderName;
    }

    public String getEmail() {
      return email;
    }
  }

  public static class Card {
    private final String number;
    private final String holderName;
    private final String expirationDate;
    private final String countryIssue;

    public Card(String number, String holderName, String expirationDate, String countryIssue) {
      this.number = number;
      this.holderName = holderName;
      this.expirationDate = expirationDate;
      this.countryIssue = countryIssue;
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

  public static class Payment {
    private final String id;
    private final String paymentMethod;
    private final Double subtotal;
    private final Double total;
    private final Double discount;
    private final Card card;
    private final Pse pse;
    private final BillingAddress billingAddress;

    public Payment(String id, String paymentMethod, Double subtotal, Double total, Double discount, Card card, Pse pse, BillingAddress billingAddress) {
      this.id = id;
      this.paymentMethod = paymentMethod;
      this.subtotal = subtotal;
      this.total = total;
      this.discount = discount;
      this.card = card;
      this.pse = pse;
      this.billingAddress = billingAddress;
    }

    public String getId() {
      return id;
    }

    public String getPaymentMethod() {
      return paymentMethod;
    }

    public Double getSubtotal() {
      return subtotal;
    }

    public Double getTotal() {
      return total;
    }

    public Double getDiscount() {
      return discount;
    }

    public Card getCard() {
      return card;
    }

    public Pse getPse() {
      return pse;
    }

    public BillingAddress getBillingAddress() {
      return billingAddress;
    }
  }

}
