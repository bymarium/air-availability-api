package com.airsofka.authentication.infra.mysql.adapters;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.infra.mysql.entities.UserSql;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class MysqlAdapter implements IUserRepositoryPort {

    private final IUserRepository repository;

    public MysqlAdapter(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void register(User user) {
        UserSql userSql = new UserSql();

        if(user.getMethodAuthentication().getValue().equals("LOCAL")){
            userSql.setId(user.getIdentity().getValue());
            userSql.setName(user.getName().getValue());
            userSql.setPassword(user.getPassword().getValue());
            userSql.setEmail(user.getEmail().getValue());
            userSql.setDocumentId(user.getDocumentID().getValue());
            userSql.setPhoneNumber(user.getPhoneNumber().getValue());
            userSql.setNacionality(user.getNacionality().getValue());
            userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
            userSql.setRole(user.getRole().getValue());
            userSql.setIsFrequent(user.getIsFrequent().getValue());
            repository.save(userSql);
        }else{
            userSql.setId(user.getIdentity().getValue());
            userSql.setName(user.getName().getValue());
            userSql.setEmail(user.getEmail().getValue());
            userSql.setRole(user.getRole().getValue());
            userSql.setIsFrequent(user.getIsFrequent().getValue());
            userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
            repository.save(userSql);
        }

    }



}
