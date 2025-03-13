package com.airsofka.admin.domain.admin.entities;

import com.airsofka.admin.domain.admin.values.*;
import com.airsofka.shared.domain.generic.Entity;

public class Booking extends Entity<BookingId> {
    private ArrivalDate arrivalDate;
    private BookingCode bookingCode;
    private CreationDate creationDate;
    private DepartureDate departureDate;
    private Destination destination;
    private Email email;
    private FlightClass flightClass;
    private Origin origin;
    private Passengers passengers;
    private PaymentMethod paymentMethod;
    private Price price;
    private State state;

    // region Constructors
    public Booking(ArrivalDate arrivalDate, BookingCode bookingCode, CreationDate creationDate, DepartureDate departureDate, Destination destination, Email email, FlightClass flightClass, Origin origin, Passengers passengers, PaymentMethod paymentMethod, Price price, State state) {
        super(new BookingId());
        this.arrivalDate = arrivalDate;
        this.bookingCode = bookingCode;
        this.creationDate = creationDate;
        this.departureDate = departureDate;
        this.destination = destination;
        this.email = email;
        this.flightClass = flightClass;
        this.origin = origin;
        this.passengers = passengers;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.state = state;
    }

    public Booking(BookingId identity, ArrivalDate arrivalDate, BookingCode bookingCode, CreationDate creationDate, DepartureDate departureDate, Destination destination, Email email, FlightClass flightClass, Origin origin, Passengers passengers, PaymentMethod paymentMethod, Price price, State state) {
        super(identity);
        this.arrivalDate = arrivalDate;
        this.bookingCode = bookingCode;
        this.creationDate = creationDate;
        this.departureDate = departureDate;
        this.destination = destination;
        this.email = email;
        this.flightClass = flightClass;
        this.origin = origin;
        this.passengers = passengers;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.state = state;
    }

    public Booking() {
        super(new BookingId());
    }

    // endregion

    // region Public Methods
    public void issue(BookingCode bookingCode) {
        if (!this.bookingCode.equals(bookingCode)) throw new IllegalArgumentException("Invalid booking code. Cannot issue this booking.");

        String currentState = this.state.getValue().toLowerCase();

        if (currentState.equals("issued")) throw new IllegalStateException("This booking is already issued.");

        if (currentState.equals("canceled")) throw new IllegalStateException("A canceled booking cannot be issued.");

        this.state = State.of("Issued");
    }

    public void cancel(BookingCode bookingCode) {
        if (!this.bookingCode.equals(bookingCode)) throw new IllegalArgumentException("Invalid booking code. Cannot cancel this booking.");

        String currentState = this.state.getValue().toLowerCase();

        if (currentState.equals("canceled")) throw new IllegalStateException("This booking is already canceled.");

        if (currentState.equals("issued")) throw new IllegalStateException("An issued booking cannot be canceled.");

        this.state = State.of("Canceled");
    }

    public void confirm() {

    }
    // endregion

    // region Getters and Setters
    public ArrivalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(ArrivalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public BookingCode getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(BookingCode bookingCode) {
        this.bookingCode = bookingCode;
    }

    public CreationDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(CreationDate creationDate) {
        this.creationDate = creationDate;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(DepartureDate departureDate) {
        this.departureDate = departureDate;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    // endregion
}
