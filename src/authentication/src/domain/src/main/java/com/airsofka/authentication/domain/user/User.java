package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.events.*;
import com.airsofka.authentication.domain.user.entities.ReservationCounter;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.IsAuthenticated;
import com.airsofka.authentication.domain.user.values.IsFrequent;
import com.airsofka.authentication.domain.user.values.MethodAuthentication;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;
import com.airsofka.authentication.domain.user.values.Role;
import com.airsofka.authentication.domain.user.values.State;
import com.airsofka.authentication.domain.user.values.StateEnum;
import com.airsofka.authentication.domain.user.values.UserId;
import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.List;


public class User extends AggregateRoot<UserId> {
  private Name fullName;
  private Email email;
  private Password password;
  private DocumentID documentID;
  private PhoneNumber phoneNumber;
  private Nacionality nacionality;
  private IsFrequent isFrequent;
  private Role role;
  private State state;
  private MethodAuthentication methodAuthentication;
  private IsAuthenticated isAuthenticated;
  private ReservationCounter reservationCounter;

  // region Constructors
  public User() {
    super(new UserId());
    subscribe(new UserHandler(this));
  }

  private User(UserId identity) {
    super(identity);
    subscribe(new UserHandler(this));
  }
  // endregion

  // region Getters and Setters
  public Name getName() {
    return fullName;
  }

  public void setName(Name name) {
    this.fullName = name;
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

  public DocumentID getDocumentID() {
    return documentID;
  }

  public void setDocumentID(DocumentID documentID) {
    this.documentID = documentID;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Nacionality getNacionality() {
    return nacionality;
  }

  public void setNacionality(Nacionality nacionality) {
    this.nacionality = nacionality;
  }

  public IsFrequent getIsFrequent() {
    return isFrequent;
  }

  public void setIsFrequent(IsFrequent isFrequent) {
    this.isFrequent = isFrequent;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public MethodAuthentication getMethodAuthentication() {
    return methodAuthentication;
  }

  public void setMethodAuthentication(MethodAuthentication methodAuthentication) {
    this.methodAuthentication = methodAuthentication;
  }

  public IsAuthenticated getIsAuthenticated() {
    return isAuthenticated;
  }

  public void setIsAuthenticated(IsAuthenticated isAuthenticated) {
    this.isAuthenticated = isAuthenticated;
  }

  public ReservationCounter getReservationCounter() {
    return reservationCounter;
  }

  public void setReservationCounter(ReservationCounter reservationCounter) {
    this.reservationCounter = reservationCounter;
  }

  // endregion

  // region Domain Actions
  public void registerUser(String name, String email, String password, String documentId, String phoneNumber, String nacionality){
    apply(new RegisteredUser(name, email, password, documentId,phoneNumber, nacionality));
  }

  public void registerGoogleUser(String name, String email){
    apply(new RegisteredGoogleUser(name,email));
  }

  public void authenticateUser(String email, String password) {
    apply(new AuthenticatedUser(email, password));
  }

  public void authenticateGoogleUser(String email, String fullName) {
    apply(new AuthenticatedGoogleUser(email, fullName));
  }

  public void loggedOutUser() {
    apply(new LoggedOutUser());
  }

  public void updateIsFrequentUser(Integer counter, Integer counterFrequent) {
    apply(new UpdatedIsFrequentUser(counter, counterFrequent));
  }

  public void modifyUser(String fullName, String email, String password, String documentId, String phoneNumber, String nacionality) {
    apply(new ModifiedUser(fullName, email, password, documentId, phoneNumber, nacionality));
  }

  public void toggleUser() {
    apply(new ToggledUser());
  }

  // endregion

  // region Public Methods
  public void validateStatedUser() {
    if(state.getValue().equals(StateEnum.INACTIVE.name())) {
      throw new IllegalStateException("Inactive user cannot be authenticated");
    }
  }

  public void validateAlreadyAuthenticated() {
    if(isAuthenticated.getValue()) {
      throw new IllegalStateException("User is already authenticated");
    }
  }

  public void toggleIsAuthenticated() {
    isAuthenticated = IsAuthenticated.of(!isAuthenticated.getValue());
  }

  public void toggleState() {

    if(state.getValue().equals(StateEnum.ACTIVE.name())) {
      state = State.of(StateEnum.INACTIVE.name());
    } else {
      state = State.of(StateEnum.ACTIVE.name());
    }
  }

  public static User from(final String identity, final List<DomainEvent> events) {
    User user = new User(UserId.of(identity));
    events.forEach(user::apply);
    user.markEventsAsCommitted();
    return user;
  }
  // endregion

}
