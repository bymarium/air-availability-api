package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.modifyuserasadmin.ModifyUserAsAdminRequest;
import com.airsofka.authentication.application.modifyuserasadmin.ModifyUserAsAdminUseCase;
import com.airsofka.authentication.application.shared.users.UserResponse;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/modify-user-as-admin")
public class ModifyUserAsAdminController {
  private final ModifyUserAsAdminUseCase modifyUserAsAdminUseCase;

  public ModifyUserAsAdminController(ModifyUserAsAdminUseCase modifyUserAsAdminUseCase) {
    this.modifyUserAsAdminUseCase = modifyUserAsAdminUseCase;
  }

  @PutMapping
  public Mono<UserResponse> modifyUserAsAdmin(@RequestBody ModifyUserAsAdminRequest request){
    return modifyUserAsAdminUseCase.execute(request);
  }
}
