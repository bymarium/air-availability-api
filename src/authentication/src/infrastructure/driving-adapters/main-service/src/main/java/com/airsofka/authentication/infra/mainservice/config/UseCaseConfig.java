package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.getAllUser.GetAllUserUseCase;
import com.airsofka.authentication.application.getByEmailUser.GetByEmailUserUseCase;
import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import com.airsofka.authentication.infra.googleAuth.adapters.GoogleAdapter;
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

    @Bean
    public RegisterUserGoogleUseCase registerUserGoogleUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter, GoogleAdapter googleAdapter){
        return new RegisterUserGoogleUseCase(adapter,mysqlAdapter,googleAdapter);
    }

    @Bean
    public GetAllUserUseCase getAllUserUseCase(MysqlAdapter mysqlAdapter){
        return new GetAllUserUseCase(mysqlAdapter);
    }

    @Bean
    public GetByEmailUserUseCase getByEmailUserUseCase(MysqlAdapter mysqlAdapter){
        return new GetByEmailUserUseCase(mysqlAdapter);
    }





}
