package com.airsofka.authentication.application.shared.ports;

public interface IJwtServicePort {
  String createToken(String id, String subject);
  String getId(String jwt);
  String getSubject(String jwt);
}
