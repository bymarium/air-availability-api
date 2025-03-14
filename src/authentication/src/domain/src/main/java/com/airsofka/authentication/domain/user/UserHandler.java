package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.entities.ReservationCounter;
import com.airsofka.authentication.domain.user.events.*;
import com.airsofka.authentication.domain.user.values.Counter;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.IsAuthenticated;
import com.airsofka.authentication.domain.user.values.IsFrequent;
import com.airsofka.authentication.domain.user.values.MethodAuthentication;
import com.airsofka.authentication.domain.user.values.MethodEnum;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;
import com.airsofka.authentication.domain.user.values.Role;
import com.airsofka.authentication.domain.user.values.RoleEnum;
import com.airsofka.authentication.domain.user.values.State;
import com.airsofka.authentication.domain.user.values.StateEnum;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class UserHandler extends DomainActionsContainer {
  public UserHandler(User user) {
    addAction(registerUser(user));
    addAction(registerGoogleUser(user));
    addAction(authenticateUser(user));
    addAction(authenticateGoogleUser(user));
    addAction(loggedOutUser(user));
    addAction(updateIsFrequent(user));
    addAction(modifyUser(user));
    addAction(toggleUser(user));
  }

  public Consumer<? extends DomainEvent> registerUser(User user) {
    return (RegisteredUser event) -> {
      user.setName(Name.of(event.getName()));
      user.setEmail(Email.of(event.getEmail()));
      user.setPassword(Password.of(event.getPassword()));
      user.setDocumentID(DocumentID.of(event.getDocumentId()));
      user.setNacionality(Nacionality.of(event.getNacionality()));
      user.setPhoneNumber(PhoneNumber.of(event.getPhoneNumber()));
      user.setMethodAuthentication(MethodAuthentication.of(MethodEnum.LOCAL.name()));
      user.setRole(Role.of(RoleEnum.USER.name()));
      user.setState(State.of(StateEnum.ACTIVE.name()));
      user.setIsFrequent(IsFrequent.of(false));
      user.setIsAuthenticated(IsAuthenticated.of(false));
      user.setReservationCounter(new ReservationCounter(Counter.of(0)));
    };
  }

  public Consumer<? extends DomainEvent> registerGoogleUser(User user) {
    return (RegisteredGoogleUser event) -> {
      user.setName(Name.of(event.getFullName()));
      user.setEmail(Email.of(event.getEmail()));
      user.setMethodAuthentication(MethodAuthentication.of(MethodEnum.GOOGLE.name()));
      user.setRole(Role.of(RoleEnum.USER.name()));
      user.setState(State.of(StateEnum.ACTIVE.name()));
      user.setIsFrequent(IsFrequent.of(false));
      user.setIsAuthenticated(IsAuthenticated.of(false));
      user.setReservationCounter(new ReservationCounter(Counter.of(0)));
    };
  }

  public Consumer<? extends DomainEvent> authenticateUser(User user) {
    return (AuthenticatedUser event) -> {
      user.validateStatedUser();
      user.validateAlreadyAuthenticated();

      if (!user.getEmail().getValue().equals(event.getEmail()) || !event.getPassword().equals(user.getPassword().getValue())) {
        throw new IllegalStateException("Invalid email or password");
      }
      user.toggleIsAuthenticated();
    };
  }

  public Consumer<? extends DomainEvent> authenticateGoogleUser(User user) {
    return (AuthenticatedGoogleUser event) -> {
      user.validateStatedUser();
      user.validateAlreadyAuthenticated();

      if (!user.getEmail().getValue().equals(event.getEmail()) || !user.getName().getValue().equals(event.getFullName())) {
        throw new IllegalStateException("Invalid user");
      }

      user.toggleIsAuthenticated();
    };
  }

  public Consumer<? extends DomainEvent> loggedOutUser(User user) {
    return (LoggedOutUser event) -> {
      user.validateStatedUser();

      if(!user.getIsAuthenticated().getValue()) {
        throw new IllegalStateException("User must be authenticated");
      }

      user.toggleIsAuthenticated();
    };
  }

  public Consumer<? extends DomainEvent> updateIsFrequent(User user) {
    return (UpdatedIsFrequentUser event) -> {
      user.validateStatedUser();

      user.getReservationCounter().setCounter(Counter.of(event.getCounter()));
      if(user.getReservationCounter().checkCounter(event.getCounterFrequent())) {
        user.setIsFrequent(IsFrequent.of(true));
      } else {
        user.setIsFrequent(IsFrequent.of(false));
      }
    };
  }

  public Consumer<? extends DomainEvent> modifyUser(User user) {
    return (ModifiedUser event) -> {
      user.setName(Name.of(event.getFullName()));
      user.setEmail(Email.of(event.getEmail()));
      user.setPassword(Password.of(event.getPassword()));
      user.setDocumentID(DocumentID.of(event.getDocumentId()));
      user.setNacionality(Nacionality.of(event.getNacionality()));
      user.setPhoneNumber(PhoneNumber.of(event.getPhoneNumber()));
    };
  }

  public Consumer<? extends DomainEvent> toggleUser(User user) {
    return (ToggledUser event) -> user.toggleState();
  }

}
