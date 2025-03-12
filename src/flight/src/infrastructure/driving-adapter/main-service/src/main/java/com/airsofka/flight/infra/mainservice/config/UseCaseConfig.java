package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.flight.application.flight.changeRoute.ChangeRouteUseCase;
import com.airsofka.flight.application.flight.changeSeat.ChangeSeatUseCase;
import com.airsofka.flight.application.flight.changeStatus.ChangeStatusUseCase;
import com.airsofka.flight.application.flight.createFlight.CreateFlightUseCase;
import com.airsofka.flight.application.flight.enableSeat.EnableSeatUseCase;
import com.airsofka.flight.application.flight.getFlights.GetFlightUseCase;
import com.airsofka.flight.application.flight.getSeatsByFlight.GetSeatsByIdUseCase;
import com.airsofka.flight.application.flight.removeFlight.RemoveFlightUseCase;
import com.airsofka.flight.application.flight.searchFlights.SearchFlightUseCase;
import com.airsofka.flight.application.flight.updateFlight.UpdateFlightUseCase;
import com.airsofka.flight.application.route.deleteRoute.DeleteRouteUseCase;
//import com.airsofka.flight.application.route.displayRoute.DisplayRouteUseCase;
import com.airsofka.flight.application.route.displayRoute.DisplayRouteUseCase;
import com.airsofka.flight.application.route.listRoutes.ListRoutesUseCase;
import com.airsofka.flight.application.route.updateRoute.UpdateRouteUseCase;
import com.airsofka.infra.mongo.adapters.MongoAdapter;
import com.airsofka.flight.application.route.createRoute.CreateRouteUseCase;

import com.airsofka.infra.sql.adapters.MySQLAdapter;
import com.airsofka.infra.sql.adapters.MySQLAdapterRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreateFlightUseCase createFlightUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new CreateFlightUseCase(adapter,mysqlAdapter);
    }

    @Bean
    public UpdateFlightUseCase updateFlightUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new UpdateFlightUseCase(adapter,mysqlAdapter);
    }
    @Bean
    public GetFlightUseCase getFlightUseCase(MySQLAdapter mysqlAdapter){
        return new GetFlightUseCase(mysqlAdapter);
    }
    @Bean
    public ChangeStatusUseCase changeStatusUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new ChangeStatusUseCase(adapter,mysqlAdapter);
    }
    @Bean
    public ChangeRouteUseCase changeRouteUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new ChangeRouteUseCase(adapter,mysqlAdapter);
    }

    @Bean
    public ChangeSeatUseCase changeSeatUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new ChangeSeatUseCase(adapter,mysqlAdapter);
    }

    @Bean
    public RemoveFlightUseCase removeFlightUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter){
        return new RemoveFlightUseCase(adapter,mysqlAdapter);
    }

    @Bean
    public CreateRouteUseCase createRouteUseCase(MongoAdapter adapter, MySQLAdapterRoute mysqlAdapter){ return new CreateRouteUseCase(adapter, mysqlAdapter); }

    @Bean
    public DeleteRouteUseCase deleteRouteUseCase(MongoAdapter adapter, MySQLAdapterRoute mysqlAdapter){ return new DeleteRouteUseCase(adapter, mysqlAdapter); }

    @Bean
    public UpdateRouteUseCase updateRouteUseCase(MongoAdapter adapter, MySQLAdapterRoute mysqlAdapter){ return new UpdateRouteUseCase(adapter, mysqlAdapter); }

    @Bean
    public DisplayRouteUseCase displayRouteUseCase(MongoAdapter adapter, MySQLAdapterRoute mysqlAdapter){ return new DisplayRouteUseCase(mysqlAdapter); }

    @Bean
    public GetSeatsByIdUseCase getSeatByIDUseCase(MySQLAdapter mySQLAdapter) {
        return new GetSeatsByIdUseCase(mySQLAdapter);
    }
    @Bean
    public EnableSeatUseCase enableSeatUseCase(MongoAdapter adapter, MySQLAdapter mysqlAdapter) {
        return new EnableSeatUseCase(adapter, mysqlAdapter);
    }
    @Bean
    public ListRoutesUseCase listRoutesUseCase(MySQLAdapterRoute mysqlAdapter){ return new ListRoutesUseCase(mysqlAdapter); }

    @Bean
    public SearchFlightUseCase searchFlightUseCase(MySQLAdapter mysqlAdapter, MySQLAdapterRoute mysqlAdapterRoute){ return new SearchFlightUseCase(mysqlAdapter, mysqlAdapterRoute); }
}
