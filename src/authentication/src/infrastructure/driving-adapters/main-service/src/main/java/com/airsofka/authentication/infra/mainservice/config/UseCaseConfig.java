package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.checkuserexists.CheckUserExistsUseCase;
import com.airsofka.authentication.application.generatetoken.GenerateTokenUseCase;
import com.airsofka.authentication.application.getalluser.GetAllUserUseCase;
import com.airsofka.authentication.application.getbyemailuser.GetByEmailUserUseCase;
import com.airsofka.authentication.application.loginuser.LoginUserUseCase;
import com.airsofka.authentication.application.loginusergoogle.LoginUserGoogleUseCase;
import com.airsofka.authentication.application.logoutuser.LogOutUserUseCase;
import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import com.airsofka.authentication.infra.googleAuth.adapters.GoogleAdapter;
import com.airsofka.authentication.infra.jwt.adapters.JwtAdapter;
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
    public LoginUserUseCase loginUserUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter, JwtAdapter jwtAdapter){
        return new LoginUserUseCase(adapter,mysqlAdapter,jwtAdapter);
    }

    @Bean
    public LoginUserGoogleUseCase loginUserGoogleUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter, GoogleAdapter googleAdapter, JwtAdapter jwtAdapter){
        return new LoginUserGoogleUseCase(adapter,mysqlAdapter,googleAdapter,jwtAdapter);
    }

    @Bean
    public LogOutUserUseCase logOutUserUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter, JwtAdapter jwtAdapter){
        return new LogOutUserUseCase(mysqlAdapter,adapter,jwtAdapter);
    }

    @Bean
    public CheckUserExistsUseCase checkUserExistsUseCase(MysqlAdapter mysqlAdapter){
        return new CheckUserExistsUseCase(mysqlAdapter);
    }

    @Bean
    public GenerateTokenUseCase generateTokenUseCase(MysqlAdapter mysqlAdapter, JwtAdapter jwtAdapter){
        return new GenerateTokenUseCase(mysqlAdapter,jwtAdapter);
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
