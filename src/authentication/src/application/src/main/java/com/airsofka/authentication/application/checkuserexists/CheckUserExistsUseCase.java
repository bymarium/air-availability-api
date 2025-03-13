package com.airsofka.authentication.application.checkuserexists;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.shared.application.ICommandUseCase;

public class CheckUserExistsUseCase implements ICommandUseCase<CheckUserExistsRequest, Boolean> {
  private final IUserRepositoryPort repositoryPort;

  public CheckUserExistsUseCase(IUserRepositoryPort repositoryPort) {
    this.repositoryPort = repositoryPort;
  }

  @Override
  public Boolean execute(CheckUserExistsRequest request) {
    return repositoryPort.getByEmailUser(request.getEmail()) != null;
  }
}
