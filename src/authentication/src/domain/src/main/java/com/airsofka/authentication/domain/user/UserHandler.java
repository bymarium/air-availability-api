package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.events.AuthenticatedUser;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class UserHandler extends DomainActionsContainer {
  public UserHandler(User user) {
    add(authenticateUser(user));
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
