package com.airsofka.authentication.infra.mainservice.Controllers;

import com.airsofka.authentication.application.getByEmailUser.GetByEmailUserRequest;
import com.airsofka.authentication.application.getByEmailUser.GetByEmailUserUseCase;
import com.airsofka.authentication.application.shared.users.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/getByEmail")
public class GetByEmailUserController {

    private final GetByEmailUserUseCase getByEmailUserUseCase;

    public GetByEmailUserController(GetByEmailUserUseCase getByEmailUserUseCase) {
        this.getByEmailUserUseCase = getByEmailUserUseCase;
    }

    @GetMapping
    public UserResponse execute (@RequestBody GetByEmailUserRequest request){
        return getByEmailUserUseCase.execute(request);
    }


}
