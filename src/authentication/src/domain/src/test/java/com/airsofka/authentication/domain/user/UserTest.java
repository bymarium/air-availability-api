package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.IsAuthenticated;
import com.airsofka.authentication.domain.user.values.Password;
import com.airsofka.authentication.domain.user.values.State;
import com.airsofka.authentication.domain.user.values.StateEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
  private User user;

  @BeforeEach
  void setUp() {
    user = new User();
  }

  @Test
  void testAuthenticateUserSuccess() {
    user.setEmail(Email.of("email@example.com"));
    user.setPassword(Password.of("password1234*"));
    user.setState(State.of(StateEnum.ACTIVE.name()));
    user.setIsAuthenticated(IsAuthenticated.of(false));
    user.authenticateUser("email@example.com", true);
    assertTrue(user.getIsAuthenticated().getValue());
  }

  @Test
  void testAuthenticateUserFailWrongEmail() {
    user.setEmail(Email.of("email@example.com"));
    user.setPassword(Password.of("password1234*"));
    user.setState(State.of(StateEnum.ACTIVE.name()));
    user.setIsAuthenticated(IsAuthenticated.of(false));
    assertThrows(IllegalStateException.class, () -> {
      user.authenticateUser("email@example.com", false);
    });
  }
}