package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.modifyuser.ModifyUserRequest;
import com.airsofka.authentication.application.modifyuser.ModifyUserUseCase;
import com.airsofka.authentication.application.shared.users.UserResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/modify-user")
public class ModifyUserController {
  private final ModifyUserUseCase modifyUserUseCase;

  public ModifyUserController(ModifyUserUseCase modifyUserUseCase) {
    this.modifyUserUseCase = modifyUserUseCase;
  }

  @PutMapping
  public Mono<UserResponse> modifyUserAsAdmin(@RequestBody ModifyUserRequest request){
    return modifyUserUseCase.execute(request);
  }
}
