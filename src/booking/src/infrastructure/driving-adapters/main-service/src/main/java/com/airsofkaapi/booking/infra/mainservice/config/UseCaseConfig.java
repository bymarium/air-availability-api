package com.airsofkaapi.booking.infra.mainservice.config;

import com.airsofkaapi.booking.application.createReservation.CreateReservationUseCase;
import com.airsofkaapi.booking.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
  @Bean
  public CreateReservationUseCase createReservationUseCase(MongoAdapter mongoAdapter) {
    return new CreateReservationUseCase(mongoAdapter);
  }

}
