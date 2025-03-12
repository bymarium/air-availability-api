package com.airsofka.shared.domain.generic;

public abstract class Entity<I extends Identity> {
  private final I identity;


  protected Entity(final I identity) {
    this.identity = identity;
  }

  public String getIdentity() {
    return identity;
  }
}
