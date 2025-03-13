package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.infra.jwt.adapters.JwtAdapter;
import com.airsofka.authentication.infra.jwt.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
  @Bean
  public JwtAdapter jwtAdapter(JwtUtil jwtUtil) {
    return new JwtAdapter(jwtUtil);
  }

  @Bean
  public JwtUtil jwtUtil() {
    return new JwtUtil();
  }
}
