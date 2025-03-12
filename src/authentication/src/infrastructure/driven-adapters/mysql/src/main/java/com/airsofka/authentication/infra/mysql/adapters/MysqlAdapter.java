package com.airsofka.authentication.infra.mysql.adapters;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.infra.mysql.entities.UserSql;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;
import com.airsofka.authentication.infra.mysql.utils.UserResponseMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.airsofka.authentication.infra.mysql.utils.UserResponseMapper.mapperSql;

@Service
public class MysqlAdapter implements IUserRepositoryPort {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public MysqlAdapter(IUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user) {
        String encryptPassword = passwordEncoder.encode(user.getPassword().getValue());
        UserSql userSql = new UserSql();
        userSql.setId(user.getIdentity().getValue());
        userSql.setName(user.getName().getValue());
        userSql.setPassword(encryptPassword);
        userSql.setEmail(user.getEmail().getValue());
        userSql.setDocumentId(user.getDocumentID().getValue());
        userSql.setPhoneNumber(user.getPhoneNumber().getValue());
        userSql.setNacionality(user.getNacionality().getValue());
        userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
        userSql.setRole(user.getRole().getValue());
        userSql.setIsFrequent(user.getIsFrequent().getValue());
        repository.save(userSql);
    }

    @Override
    public void registerGoogle(User user) {
        if(repository.findByEmail(user.getEmail().getValue()).isPresent()){
            throw new IllegalStateException("El email ya está registrado: " + user.getEmail().getValue());
        }
        UserSql userSql = new UserSql();
        userSql.setId(user.getIdentity().getValue());
        userSql.setName(user.getName().getValue());
        userSql.setEmail(user.getEmail().getValue());
        userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
        repository.save(userSql);
    }

    @Override
    public List<UserResponse> getAllUser() {
        return repository.findAll().stream().map(UserResponseMapper::mapperSql).collect(Collectors.toList());
    }

    @Override
    public UserResponse getByEmailUser(String email) {
        Optional<UserSql> userSqlOpt = repository.findByEmail(email);
        if (userSqlOpt.isPresent()) {
            UserSql userSql = userSqlOpt.get();
            return mapperSql(userSql);
        } else {
            throw new RuntimeException("No se encontró un usuario con el email: " + email);
        }
    }


}
