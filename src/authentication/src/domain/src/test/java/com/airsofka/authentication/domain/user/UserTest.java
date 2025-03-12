package com.airsofka.authentication.domain.user;

import com.airsofka.authentication.domain.user.values.Email;
import com.airsofka.authentication.domain.user.values.Password;
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
    user.authenticateUser("email@example.com", "password1234*");
    assertTrue(user.getIsAuthenticated().getValue());
  }

  @Test
  void testAuthenticateUserFailWrongEmail() {
    user.setEmail(Email.of("email@example.com"));
    user.setPassword(Password.of("password1234*"));
    assertThrows(IllegalStateException.class, () -> {
      user.authenticateUser("email@example.com", "wrong");
    });
  }
}