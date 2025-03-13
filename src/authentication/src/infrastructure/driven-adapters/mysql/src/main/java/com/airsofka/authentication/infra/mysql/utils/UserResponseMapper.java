package com.airsofka.authentication.infra.mysql.utils;

import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.infra.mysql.entities.UserSql;

public class UserResponseMapper {

    public static UserResponse mapperSql(UserSql userSql){
        return new UserResponse(userSql.getId(), userSql.getName(), userSql.getEmail(), userSql.getDocumentId(),
                userSql.getPhoneNumber(),userSql.getNacionality(),userSql.getMethodAuthentication(),userSql.getState(),
                userSql.getRole(),userSql.getIsFrequent(), userSql.getIsAuthenticated());
    }

}
