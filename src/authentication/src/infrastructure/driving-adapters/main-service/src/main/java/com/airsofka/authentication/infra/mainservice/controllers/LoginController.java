package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.loginuser.LoginUserRequest;
import com.airsofka.authentication.application.loginuser.LoginUserResponse;
import com.airsofka.authentication.application.loginuser.LoginUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/login")
public class LoginController {
  private final LoginUserUseCase loginUserUseCase;

  public LoginController(LoginUserUseCase loginUserUseCase) {
    this.loginUserUseCase = loginUserUseCase;
  }

  @PutMapping
  public ResponseEntity<Mono<LoginUserResponse>> execute(@RequestBody LoginUserRequest request) {
    return ResponseEntity.status(HttpStatus.OK).body(loginUserUseCase.execute(request));
  }
}
