package com.airsofka.authentication.infra.mainservice.triggers;

import com.airsofka.authentication.application.updateisfrequentusers.UpdateIsFrequentUserRequest;
import com.airsofka.authentication.application.updateisfrequentusers.UpdateIsFrequentUserUseCase;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserIsFrequentCheckerSheduler {
  private final UpdateIsFrequentUserUseCase updateIsFrequentUserUseCase;
  private final UpdateIsFrequentUserRequest updateIsFrequentUserRequest;

  public UserIsFrequentCheckerSheduler(UpdateIsFrequentUserUseCase updateIsFrequentUserUseCase) {
    this.updateIsFrequentUserUseCase = updateIsFrequentUserUseCase;
    Integer counterFrequent = 10;
    this.updateIsFrequentUserRequest = new UpdateIsFrequentUserRequest(counterFrequent);
  }

  @Scheduled(fixedRate = 5000)
  public void checkAllUsersIsFrequent() {
    updateIsFrequentUserUseCase.execute(updateIsFrequentUserRequest).subscribe();
  }
}
