package com.airsofkaapi.booking.infra.mainservice.config;

import com.airsofkaapi.booking.infra.sql.adapters.MySQLAdapter;
import com.airsofkaapi.booking.infra.sql.repositories.IReservationRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofkaapi.booking.infra.sql.entities")
@EnableJpaRepositories(basePackages = "com.airsofkaapi.booking.infra.sql.repositories")
public class SQLConfig {
  @Bean
  public MySQLAdapter mySQLAdapter(IReservationRepository reservationRepository) {
    return new MySQLAdapter(reservationRepository);
  }
}
