package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.generatetoken.GenerateTokenRequest;
import com.airsofka.authentication.application.generatetoken.GenerateTokenUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class TokenController {
  private final GenerateTokenUseCase generateTokenUseCase;

  public TokenController(GenerateTokenUseCase generateTokenUseCase) {
    this.generateTokenUseCase = generateTokenUseCase;
  }

  @PostMapping
  public String getUserToken(@RequestBody GenerateTokenRequest request){
    return generateTokenUseCase.execute(request);
  }
}
