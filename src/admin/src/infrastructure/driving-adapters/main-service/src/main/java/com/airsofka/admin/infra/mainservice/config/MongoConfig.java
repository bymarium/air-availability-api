package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.infra.mongo.adapters.MongoAdapter;
import com.airsofka.admin.infra.mongo.repositories.IEventsRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofka.admin.infra.mongo.entities")
@EnableReactiveMongoRepositories(basePackages = "com.airsofka.admin.infra.mongo.repositories")
public class MongoConfig {
    @Bean
    public MongoAdapter mongoAdapter(IEventsRepository repository) {
        return new MongoAdapter(repository);
    }

//    @Bean
//    public MongoClient reactiveMongoClient() {
//        return MongoClients.create("mongodb://localhost:27017");
//    }
//
//    @Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient mongoClient) {
//        return new ReactiveMongoTemplate(mongoClient, "AirSofka");
//    }
//
//    @Bean
//    public MongoAdapter mongoAdapter(IEventsRepository repository) {
//        return new MongoAdapter(repository);
//    }

}
