package com.airsofka.authentication.application.decodetoken;

import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class DecodeTokenUseCase implements ICommandUseCase<DecodeTokenRequest, Mono<DecodeTokenResponse>> {
  private final IJwtServicePort jwtServicePort;

  public DecodeTokenUseCase(IJwtServicePort jwtServicePort) {
    this.jwtServicePort = jwtServicePort;
  }

  @Override
  public Mono<DecodeTokenResponse> execute(DecodeTokenRequest request) {
    return Mono.just(
      new DecodeTokenResponse(
        jwtServicePort.getId(request.getToken()),
        jwtServicePort.getSubject(request.getToken()),
        jwtServicePort.getClaims(request.getToken()).get("role").toString(),
        jwtServicePort.getClaims(request.getToken()).get("isFrequent").toString().equals("true")
      )
    );
  }
}
