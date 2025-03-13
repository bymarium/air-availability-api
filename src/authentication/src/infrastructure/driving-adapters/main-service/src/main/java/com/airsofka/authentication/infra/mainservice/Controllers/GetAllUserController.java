package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.getalluser.GetAllUserResponse;
import com.airsofka.authentication.application.getalluser.GetAllUserUseCase;
import com.airsofka.authentication.application.shared.users.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getAllUsers")
public class GetAllUserController {

    private final GetAllUserUseCase getAllUserUseCase;

    public GetAllUserController(GetAllUserUseCase getAllUserUseCase) {
        this.getAllUserUseCase = getAllUserUseCase;
    }

    @GetMapping
    public List<UserResponse> execute(){
        return getAllUserUseCase.execute();
    }

}
