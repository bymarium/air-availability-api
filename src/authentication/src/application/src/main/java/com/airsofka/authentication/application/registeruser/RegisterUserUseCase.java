package com.airsofka.authentication.application.registeruser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.application.shared.users.UserMapper;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class RegisterUserUseCase  implements ICommandUseCase<RegisterUserRequest, Mono<UserResponse>> {

    private final IEventsRepositoryPort eventsRepository;
    private final IUserRepositoryPort userRepository;

    public RegisterUserUseCase(IEventsRepositoryPort eventsRepository,IUserRepositoryPort userRepository) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserResponse> execute(RegisterUserRequest request) {
        User user;
        user = UserMapper.mapperLocal(request);
        user.registerUser(user.getName().getValue(),user.getEmail().getValue(),user.getPassword().getValue(),user.getDocumentID().getValue(),user.getPhoneNumber().getValue(),user.getNacionality().getValue());
        user.getUncommittedEvents().forEach(eventsRepository::save);
        user.markEventsAsCommitted();
        userRepository.register(user);
        return Mono.just(new UserResponse(
                user.getIdentity().getValue(),
                user.getName().getValue(),
                user.getEmail().getValue(),
                user.getDocumentID().getValue(),
                user.getPhoneNumber().getValue(),
                user.getNacionality().getValue(),
                user.getMethodAuthentication().getValue(),
                user.getState().getValue(),
                user.getRole().getValue(),
                user.getIsFrequent().getValue(),
                user.getIsAuthenticated().getValue()
            ));
    }
}
