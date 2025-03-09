package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.flight.application.flight.assignRoute.AssignRouteUseCase;
import com.airsofka.flight.application.flight.changeRoute.ChangeRouteUseCase;
import com.airsofka.flight.application.flight.changeSeat.ChangeSeatUseCase;
import com.airsofka.flight.application.flight.changeStatus.ChangeStatusUseCase;
import com.airsofka.flight.application.flight.createFlight.CreateFlightUseCase;
import com.airsofka.flight.application.flight.enableSeat.EnableSeatUseCase;
import com.airsofka.flight.application.flight.updateFlight.UpdateFlightUseCase;
import com.airsofka.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateFlightUseCase createFlightUseCase(MongoAdapter adapter){
        return new CreateFlightUseCase(adapter);
    }
    @Bean
    public UpdateFlightUseCase updateFlightUseCase(MongoAdapter adapter){
        return new UpdateFlightUseCase(adapter);
    }
    @Bean
    public AssignRouteUseCase assignRouteUseCase(MongoAdapter adapter){
        return new AssignRouteUseCase(adapter);
    }
    @Bean
    public ChangeRouteUseCase changeRouteUseCase(MongoAdapter adapter){
        return new ChangeRouteUseCase(adapter);
    }
    @Bean
    public ChangeSeatUseCase changeSeatUseCase(MongoAdapter adapter){
        return new ChangeSeatUseCase(adapter);
    }
    @Bean
    public ChangeStatusUseCase changeStatusUseCase(MongoAdapter adapter){
        return new ChangeStatusUseCase(adapter);
    }
    @Bean
    public EnableSeatUseCase enableSeatUseCase(MongoAdapter adapter){
        return new EnableSeatUseCase(adapter);
    }



}
