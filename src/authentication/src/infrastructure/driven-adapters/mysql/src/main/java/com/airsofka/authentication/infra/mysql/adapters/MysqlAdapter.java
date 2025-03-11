package com.airsofka.authentication.infra.mysql.adapters;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.infra.mysql.entities.UserSql;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;

//@Service
public class MysqlAdapter implements IUserRepositoryPort {

    private final IUserRepository repository;

    public MysqlAdapter(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        UserSql userSql = new UserSql();

        if(user.getMethodAuthentication().getValue().equals("LOCAL")){
            repository.save(userSql);
        }else{
            repository.save(userSql);
        }

    }



}
