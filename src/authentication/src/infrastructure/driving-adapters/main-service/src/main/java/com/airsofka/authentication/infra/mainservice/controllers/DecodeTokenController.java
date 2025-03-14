package com.airsofka.authentication.infra.mainservice.controllers;

import com.airsofka.authentication.application.decodetoken.DecodeTokenRequest;
import com.airsofka.authentication.application.decodetoken.DecodeTokenResponse;
import com.airsofka.authentication.application.decodetoken.DecodeTokenUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/decode-token")
public class DecodeTokenController {
  private final DecodeTokenUseCase decodeTokenUseCase;

  public DecodeTokenController(DecodeTokenUseCase decodeTokenUseCase) {
    this.decodeTokenUseCase = decodeTokenUseCase;
  }

  @PostMapping
  public Mono<DecodeTokenResponse> execute(@RequestBody DecodeTokenRequest request) {
    return decodeTokenUseCase.execute(request);
  }
}
