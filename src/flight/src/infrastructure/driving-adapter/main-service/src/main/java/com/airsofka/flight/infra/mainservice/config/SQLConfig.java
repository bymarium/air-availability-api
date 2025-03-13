package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.infra.sql.adapters.MySQLAdapter;
import com.airsofka.infra.sql.repositories.FlightRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = "com.airsofka.infra.sql.repositories")
@EntityScan(basePackages = "com.airsofka.infra.sql.entities")
public class SQLConfig {
    @Bean
    public MySQLAdapter mySQLAdapter(FlightRepository flightRepository){
        return new MySQLAdapter(flightRepository);

    }
}
