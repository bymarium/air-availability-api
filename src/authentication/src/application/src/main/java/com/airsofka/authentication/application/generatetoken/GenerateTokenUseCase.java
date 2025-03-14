package com.airsofka.authentication.application.generatetoken;

import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.shared.application.ICommandUseCase;

import java.util.HashMap;
import java.util.Map;

public class GenerateTokenUseCase implements ICommandUseCase<GenerateTokenRequest, String> {
  private final IUserRepositoryPort userRepositoryPort;
  private final IJwtServicePort jwtServicePort;

  public GenerateTokenUseCase(IUserRepositoryPort userRepositoryPort, IJwtServicePort jwtServicePort) {
    this.userRepositoryPort = userRepositoryPort;
    this.jwtServicePort = jwtServicePort;
  }

  @Override
  public String execute(GenerateTokenRequest request) {
    UserResponse userResponse = userRepositoryPort.getByEmailUser(request.getEmail());

    if(Boolean.TRUE.equals(userResponse.getAuthenticated())) {
      Map<String, Object> claims = new HashMap<>();
      claims.put("isFrequent", userResponse.getFrequent());
      claims.put("role", userResponse.getRole());
      return jwtServicePort.createToken(userResponse.getId(), userResponse.getEmail(), claims);
    }
    return null;
  }
}
