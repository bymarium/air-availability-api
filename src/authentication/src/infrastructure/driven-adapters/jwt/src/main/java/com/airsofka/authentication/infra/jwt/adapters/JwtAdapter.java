package com.airsofka.authentication.infra.jwt.adapters;

import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.infra.jwt.utils.JwtUtil;

import java.util.Map;

public class JwtAdapter implements IJwtServicePort {
  private final JwtUtil jwtUtil;

  public JwtAdapter(JwtUtil jwtUtil) {
    this.jwtUtil = jwtUtil;
  }

  @Override
  public String createToken(String id, String subject, Map<String, Object> claims) {
    return jwtUtil.create(id, subject, claims);
  }

  @Override
  public boolean validateToken(String token) {
    return jwtUtil.validateToken(token);
  }

  @Override
  public String getId(String jwt) {
    return jwtUtil.getKey(jwt);
  }

  @Override
  public String getSubject(String jwt) {
    return jwtUtil.getValue(jwt);
  }

  @Override
  public Map<String, Object> getClaims(String jwt) {
    return jwtUtil.getClaims(jwt);
  }
}
