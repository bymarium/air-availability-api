package com.airsofka.authentication.application.shared.ports;

import java.util.Map;

public interface IJwtServicePort {
  String createToken(String id, String subject, Map<String, Object> claims);
  boolean validateToken(String token);
  String getId(String jwt);
  String getSubject(String jwt);
  Map<String, Object> getClaims(String jwt);
}
