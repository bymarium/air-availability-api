package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.infra.reservationapi.adapters.ReservationAPIAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ReservationAPIConfig {
  @Bean
  public ReservationAPIAdapter reservationAPIAdapter(WebClient webClient) {
    return new ReservationAPIAdapter(webClient);
  }
}
