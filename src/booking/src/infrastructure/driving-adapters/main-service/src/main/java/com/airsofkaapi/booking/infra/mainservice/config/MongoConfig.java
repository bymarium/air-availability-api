package com.airsofkaapi.booking.infra.mainservice.config;


import com.airsofkaapi.booking.infra.mongo.adapters.MongoAdapter;
import com.airsofkaapi.booking.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofkaapi.booking.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.airsofkaapi.booking.infra.mongo.repositories")
public class MongoConfig {
  @Bean
  public MongoAdapter mongoAdapter(IEventsRepository repository) {
    return new MongoAdapter(repository);
  }
}