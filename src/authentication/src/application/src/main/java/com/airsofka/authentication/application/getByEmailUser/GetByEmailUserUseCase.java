package com.airsofka.authentication.application.getByEmailUser;



import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.shared.application.ICommandUseCase;


public class GetByEmailUserUseCase implements ICommandUseCase<GetByEmailUserRequest,UserResponse> {

    private final IUserRepositoryPort repositoryPort;


    public GetByEmailUserUseCase(IUserRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public UserResponse execute(GetByEmailUserRequest request) {
        return repositoryPort.getByEmailUser(request.getEmail());
    }

}
