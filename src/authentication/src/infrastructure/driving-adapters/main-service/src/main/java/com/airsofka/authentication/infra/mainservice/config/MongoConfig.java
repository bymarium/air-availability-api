package com.airsofka.authentication.infra.mainservice.config;


import com.airsofka.authentication.infra.mongo.adapters.MongoAdapter;
import com.airsofka.authentication.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofka.authentication.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.airsofka.authentication.infra.mongo.repositories")
public class MongoConfig {
  @Bean
  public MongoAdapter mongoAdapter(IEventsRepository repository) {
    return new MongoAdapter(repository);
  }
}
