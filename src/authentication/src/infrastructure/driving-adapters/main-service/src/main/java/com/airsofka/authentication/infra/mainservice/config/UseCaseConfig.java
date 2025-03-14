package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.checkuserexists.CheckUserExistsUseCase;
import com.airsofka.authentication.application.decodetoken.DecodeTokenUseCase;
import com.airsofka.authentication.application.generatetoken.GenerateTokenUseCase;
import com.airsofka.authentication.application.getalluser.GetAllUserUseCase;
import com.airsofka.authentication.application.getbyemailuser.GetByEmailUserUseCase;
import com.airsofka.authentication.application.getreservationbycode.GetReservationByCodeUseCase;
import com.airsofka.authentication.application.loginuser.LoginUserUseCase;
import com.airsofka.authentication.application.loginusergoogle.LoginUserGoogleUseCase;
import com.airsofka.authentication.application.logoutuser.LogOutUserUseCase;
import com.airsofka.authentication.application.modifyuser.ModifyUserUseCase;
import com.airsofka.authentication.application.modifyuserasadmin.ModifyUserAsAdminUseCase;
import com.airsofka.authentication.application.toggleuser.ToggleUserUseCase;
import com.airsofka.authentication.application.updateisfrequentusers.UpdateIsFrequentUserUseCase;
import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import com.airsofka.authentication.infra.googleAuth.adapters.GoogleAdapter;
import com.airsofka.authentication.infra.jwt.adapters.JwtAdapter;
import com.airsofka.authentication.infra.mongo.adapters.MongoAdapter;
import com.airsofka.authentication.infra.mysql.adapters.MysqlAdapter;
import com.airsofka.authentication.infra.reservationapi.adapters.ReservationAPIAdapter;
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
    public DecodeTokenUseCase decodeTokenUseCase(JwtAdapter jwtAdapter){
        return new DecodeTokenUseCase(jwtAdapter);
    }

    @Bean
    public UpdateIsFrequentUserUseCase updateAsFrequentUserUseCase(ReservationAPIAdapter reservationAPIAdapter, MysqlAdapter mysqlAdapter, MongoAdapter adapter){
        return new UpdateIsFrequentUserUseCase(reservationAPIAdapter,mysqlAdapter, adapter);
    }

    @Bean
    public GetAllUserUseCase getAllUserUseCase(MysqlAdapter mysqlAdapter){
        return new GetAllUserUseCase(mysqlAdapter);
    }

    @Bean
    public GetByEmailUserUseCase getByEmailUserUseCase(MysqlAdapter mysqlAdapter){
        return new GetByEmailUserUseCase(mysqlAdapter);
    }

    @Bean
    public ToggleUserUseCase toggleUserUseCase(MysqlAdapter mysqlAdapter, MongoAdapter adapter){
        return new ToggleUserUseCase(mysqlAdapter, adapter);
    }

    @Bean
    public ModifyUserAsAdminUseCase modifyUserAsAdminUseCase(MysqlAdapter mysqlAdapter, MongoAdapter adapter){
        return new ModifyUserAsAdminUseCase(adapter, mysqlAdapter);
    }

    @Bean
    public ModifyUserUseCase modifyUserUseCase(MysqlAdapter mysqlAdapter, MongoAdapter adapter, JwtAdapter jwtAdapter){
        return new ModifyUserUseCase(adapter, mysqlAdapter, jwtAdapter);
    }

    @Bean
    public GetReservationByCodeUseCase getReservationByCodeUseCase(ReservationAPIAdapter reservationAPIAdapter){
        return new GetReservationByCodeUseCase(reservationAPIAdapter);
    }

}
