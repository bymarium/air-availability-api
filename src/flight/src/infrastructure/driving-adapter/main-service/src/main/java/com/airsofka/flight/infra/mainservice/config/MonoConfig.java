package com.airsofka.flight.infra.mainservice.config;

import com.airsofka.infra.mongo.adapters.MongoAdapter;
import com.airsofka.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofka.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.airsofka.infra.mongo.repositories")
public class MonoConfig {
    @Bean
    public MongoAdapter mongoAdapter(IEventsRepository repository){
        return new MongoAdapter(repository);
    }

}
