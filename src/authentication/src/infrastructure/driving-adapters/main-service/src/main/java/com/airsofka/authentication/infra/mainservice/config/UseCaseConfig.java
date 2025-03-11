package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import com.airsofka.authentication.infra.mongo.adapters.MongoAdapter;
import com.airsofka.authentication.infra.mysql.adapters.MysqlAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public RegisterUserUseCase registerUserUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter){
        return new RegisterUserUseCase(adapter,mysqlAdapter);
    }

}
