package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.events.AuthenticatedUser;
import com.airsofka.authentication.domain.user.events.RegisteredGoogleUser;
import com.airsofka.authentication.domain.user.events.RegisteredUser;
import com.airsofka.authentication.domain.user.values.DocumentID;
import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.MethodAuthentication;
import com.airsofka.authentication.domain.user.values.MethodEnum;
import com.airsofka.authentication.domain.user.values.Nacionality;
import com.airsofka.authentication.domain.user.values.Name;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.PhoneNumber;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class UserHandler extends DomainActionsContainer {
  public UserHandler(User user) {
    addAction(authenticateUser(user));
    addAction(registerUser(user));
    addAction(registerGoogleUser(user));
  }

    public Consumer<? extends DomainEvent> registerUser(User user){
        return (RegisteredUser event) ->{
            user.setName(Name.of(event.getName()));
            user.setEmail(Email.of(event.getEmail()));
            user.setPassword(Password.of(event.getPassword()));
            user.setDocumentID(DocumentID.of(event.getEmail()));
            user.setNacionality(Nacionality.of(event.getNacionality()));
            user.setPhoneNumber(PhoneNumber.of(event.getPhoneNumber()));
            user.setMethodAuthentication(MethodAuthentication.of(MethodEnum.LOCAL.name()));
        };
    }

    public Consumer<? extends DomainEvent> registerGoogleUser(User user){
        return (RegisteredGoogleUser event) ->{
                user.setName(Name.of(event.getFullName()));
                user.setEmail(Email.of(event.getEmail()));
                user.setMethodAuthentication(MethodAuthentication.of(MethodEnum.GOOGLE.name()));
        };
    }

  public Consumer<? extends DomainEvent> authenticateUser(User user) {
    return (AuthenticatedUser event) -> {
      user.validateStatedUser();
      user.validateAlreadyAuthenticated();

      if(!user.getEmail().getValue().equals(event.getEmail()) || !user.getPassword().getValue().equals(event.getPassword())) {
        throw new IllegalStateException("Invalid email or password");
      }
      user.toggleIsAuthenticated();
    };
  }

}
