package com.airsofka.authentication.application.getAllUser;


import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.shared.application.IQueryUseCase;

public class GetAllUserUseCase implements IQueryUseCase<GetAllUserResponse> {

    private final IUserRepositoryPort repositoryPort;

    public GetAllUserUseCase(IUserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public GetAllUserResponse execute() {
        return new GetAllUserResponse(repositoryPort.getAllUser());
    }
}
