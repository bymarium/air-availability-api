package com.airsofka.authentication.application.updateisfrequentusers;

import com.airsofka.shared.application.Request;

public class UpdateIsFrequentUserRequest extends Request {
  private final Integer counterFrequent;

  public UpdateIsFrequentUserRequest( Integer counterFrequent) {
    super(null);
    this.counterFrequent = counterFrequent;
  }
  public Integer getCounterFrequent() {
    return counterFrequent;
  }
}
