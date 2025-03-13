package com.airsofka.admin.domain.admin;

import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.events.CanceledBooking;
import com.airsofka.admin.domain.admin.events.ConfirmedBooking;
import com.airsofka.admin.domain.admin.events.GeneratedAnalytics;
import com.airsofka.admin.domain.admin.events.IssuedBooking;
import com.airsofka.admin.domain.admin.values.*;
import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AggregateRoot<AdminId> {
    private List<Booking> bookings = new ArrayList<>();
    private Email email;
    private Password password;
    private Income income;
    private Taxes taxes;
    private State state;

    // region Constructors
    public Admin() {
        super(new AdminId());
        subscribe(new AdminHandler(this));
    }

    private Admin(AdminId identity) {
        super(identity);
        subscribe(new AdminHandler(this));
    }
    // endregion

    // region Getters and Setters
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Taxes getTaxes() {
        return taxes;
    }

    public void setTaxes(Taxes taxes) {
        this.taxes = taxes;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    // endregion

    // region Domain Actions
    public void cancelBooking(String id, String bookingCode, String state) {
        apply(new CanceledBooking(id, bookingCode, state));
    }

    public void confirmBooking(String id, String bookingCode, String state) {
        apply(new ConfirmedBooking(id, bookingCode, state));
    }

    public void generateAnalytics(Double price, Double taxes, String state, Double income) {
        apply(new GeneratedAnalytics(price, taxes, state, income));
    }

    public void issueBooking(String id, String bookingCode, String state) {
        apply(new IssuedBooking(id, bookingCode, state));
    }
    // endregion

    // region Public Methods
    public static Admin from(final String identity, final List<DomainEvent> events) {
        Admin admin = new Admin(AdminId.of(identity));

        events.forEach(admin::apply);
        return admin;
    }
    // endregion
}
