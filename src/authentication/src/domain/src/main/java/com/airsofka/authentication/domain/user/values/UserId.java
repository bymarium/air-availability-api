package com.airsofka.authentication.domain.user.values;

import com.airsofka.shared.domain.generic.Identity;

public class UserId extends Identity {
  public UserId() {
    super();
  }

  public UserId(String value) {
    super(value);
  }

  public static UserId of(String value) {
    return new UserId(value);
  }
}