package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.flight.application.flight.createFlight.CreateFlightUseCase;
import com.airsofka.flight.application.flight.updateFlight.UpdateFlightUseCase;
import com.airsofka.flight.application.route.deleteRoute.DeleteRouteUseCase;
import com.airsofka.infra.mongo.adapters.MongoAdapter;
import com.airsofka.flight.application.route.createRoute.CreateRouteUseCase;

import com.airsofka.infra.sql.adapters.MySQLAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateFlightUseCase createFlightUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new CreateFlightUseCase(adapter,mysqlAdapter);
    }

    @Bean
    public UpdateFlightUseCase updateFlightUseCase(MongoAdapter adapter){
        return new UpdateFlightUseCase(adapter);
    }


    @Bean
    public CreateRouteUseCase createRouteUseCase(MongoAdapter adapter){ return new CreateRouteUseCase(adapter); }

    @Bean
    public DeleteRouteUseCase deleteRouteUseCase(MongoAdapter adapter){ return new DeleteRouteUseCase(adapter); }
}
