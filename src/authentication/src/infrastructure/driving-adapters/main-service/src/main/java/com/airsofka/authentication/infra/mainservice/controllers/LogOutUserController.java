package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.logoutuser.LogOutUserRequest;
import com.airsofka.authentication.application.logoutuser.LogOutUserUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/logout")
public class LogOutUserController {
  private final LogOutUserUseCase logOutUserUseCase;

  public LogOutUserController(LogOutUserUseCase logOutUserUseCase) {
    this.logOutUserUseCase = logOutUserUseCase;
  }

  @PutMapping
  public Mono<Boolean> execute(@RequestBody LogOutUserRequest request){
    return logOutUserUseCase.execute(request);
  }
}
