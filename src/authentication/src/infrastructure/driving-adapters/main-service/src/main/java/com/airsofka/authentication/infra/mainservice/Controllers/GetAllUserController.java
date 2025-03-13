package com.airsofka.authentication.infra.mainservice.Controllers;

import com.airsofka.authentication.application.getAllUser.GetAllUserResponse;
import com.airsofka.authentication.application.getAllUser.GetAllUserUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/getAllUsers")
public class GetAllUserController {

    private final GetAllUserUseCase getAllUserUseCase;

    public GetAllUserController(GetAllUserUseCase getAllUserUseCase) {
        this.getAllUserUseCase = getAllUserUseCase;
    }

    @GetMapping
    public GetAllUserResponse execute(){
        return getAllUserUseCase.execute();
    }


}
