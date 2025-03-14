package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.toggleuser.ToggleUserRequest;
import com.airsofka.authentication.application.toggleuser.ToggleUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class ToggleUserController {
    private final ToggleUserUseCase toggleUserUseCase;

    public ToggleUserController(ToggleUserUseCase toggleUserUseCase){
        this.toggleUserUseCase = toggleUserUseCase;
    }

    @PostMapping("/toggle")
    public Mono<Boolean> execute(@RequestBody ToggleUserRequest request){
        return toggleUserUseCase.execute(request);
    }
}
