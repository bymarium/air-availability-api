package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.flight.application.flight.createFlight.CreateFlightUseCase;
import com.airsofka.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateFlightUseCase createFlightUseCase(MongoAdapter adapter){
        return new CreateFlightUseCase(adapter);
    }


}
