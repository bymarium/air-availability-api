package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.infra.mongo.adapters.MongoAdapter;
import com.airsofka.authentication.infra.mongo.repositories.IEventsRepository;
import com.airsofka.authentication.infra.mysql.adapters.MysqlAdapter;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.airsofka.authentication.infra.mysql.entities")
@EnableJpaRepositories(basePackages = "com.airsofka.authentication.infra.mysql.repositories")
public class MysqlConfig {
    @Bean
    public MysqlAdapter mysqlAdapter(IUserRepository repository) {
        return new MysqlAdapter(repository);
    }
}
