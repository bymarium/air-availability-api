package com.airsofka.authentication.application.registeruser;

import com.airsofka.authentication.application.shared.users.UserMapper;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class RegisterUserUseCase  implements ICommandUseCase<RegisterUserRequest, Mono<RegisterUserResponse>> {


    @Override
    public Mono<RegisterUserResponse> execute(RegisterUserRequest request) {
        User user;
        if(request.getDocumentId()!=null){
             user =  UserMapper.MapperLocal(request);
        }else{
             user =  UserMapper.MapperGoogle(request);
        }

        user.

    }
}
