package com.airsofka.authentication.infra.mainservice.Controllers;

import com.airsofka.authentication.application.registeruser.RegisterUserRequest;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/register")
public class RegisterUserController {

    private final RegisterUserUseCase registerUser;

    public RegisterUserController(RegisterUserUseCase registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping
    public Mono<UserResponse> execute(@RequestBody RegisterUserRequest request){
        return registerUser.execute(request);
    }


}
