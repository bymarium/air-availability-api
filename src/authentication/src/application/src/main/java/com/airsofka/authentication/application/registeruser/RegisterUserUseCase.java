package com.airsofka.authentication.application.registeruser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserMapper;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class RegisterUserUseCase  implements ICommandUseCase<RegisterUserRequest, Mono<RegisterUserResponse>> {

    private final IEventsRepositoryPort eventsRepository;
    private final IUserRepositoryPort userRepository;

    public RegisterUserUseCase(IEventsRepositoryPort eventsRepository,IUserRepositoryPort userRepository) {
        this.eventsRepository = eventsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mono<RegisterUserResponse> execute(RegisterUserRequest request) {
        User user;
//        if(request.getDocumentId()!=null){
//            user =  UserMapper.MapperLocal(request);
//            user.registerUser(user.getName().getValue(),user.getEmail().getValue(),user.getPassword().getValue(),user.getDocumentID().getValue(),user.getPhoneNumber().getValue(),user.getNacionality().getValue());
//            user.getUncommittedEvents().forEach(eventsRepository::save);
//            user.markEventsAsCommitted();
//            userRepository.register(user);
//            return Mono.just(new RegisterUserResponse(
//                    user.getName().getValue(),
//                    user.getEmail().getValue(),
//                    user.getDocumentID().getValue(),
//                    user.getPhoneNumber().getValue(),
//                    user.getNacionality().getValue(),
//                    user.getMethodAuthentication().getValue(),
//                    user.getRole().getValue(),
//                    user.getIsFrequent().getValue()
//            ));
//        }else{
//             user =  UserMapper.MapperGoogle(request);
//             user.registerUser(user.getName().getValue(),user.getEmail().getValue());
//             user.getUncommittedEvents().forEach(eventsRepository::save);
//             user.markEventsAsCommitted();
//             userRepository.register(user);
//            return Mono.just(new RegisterUserResponse(
//                    user.getName().getValue(),
//                    user.getEmail().getValue(),
//                    user.getRole().getValue(),
//                    user.getIsFrequent().getValue(),
//                    user.getMethodAuthentication().getValue()
//            ));
//        }
            user =  UserMapper.MapperLocal(request);
            user.registerUser(user.getName().getValue(),user.getEmail().getValue(),user.getPassword().getValue(),user.getDocumentID().getValue(),user.getPhoneNumber().getValue(),user.getNacionality().getValue());
            user.getUncommittedEvents().forEach(eventsRepository::save);
            user.markEventsAsCommitted();
            userRepository.register(user);
            return Mono.just(new RegisterUserResponse(
                    user.getName().getValue(),
                    user.getEmail().getValue(),
                    user.getDocumentID().getValue(),
                    user.getPhoneNumber().getValue(),
                    user.getNacionality().getValue(),
                    user.getMethodAuthentication().getValue(),
                    user.getRole().getValue(),
                    user.getIsFrequent().getValue()
            ));

    }
}
