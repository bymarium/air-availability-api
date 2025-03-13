package com.airsofka.authentication.application.getalluser;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.shared.application.IQueryUseCase;

import java.util.List;

public class GetAllUserUseCase implements IQueryUseCase<List<UserResponse>> {

    private final IUserRepositoryPort repositoryPort;

    public GetAllUserUseCase(IUserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public List<UserResponse> execute() {
        return repositoryPort.getAllUser();
    }
}
