package com.airsofka.authentication.application.loginuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LoginUserUseCaseTest {
  private IEventsRepositoryPort repository;
  private IUserRepositoryPort userRepository;
  private IJwtServicePort jwtService;
  private LoginUserUseCase loginUserUseCase;

  public LoginUserUseCaseTest() {
    this.repository = mock(IEventsRepositoryPort.class);
    this.userRepository = mock(IUserRepositoryPort.class);
    this.jwtService = mock(IJwtServicePort.class);
    this.loginUserUseCase = new LoginUserUseCase(repository, userRepository, jwtService);
  }

  @Test
  void testExecuteSuccess() {
    System.out.println("test");
    assertNull(null);
  }
}