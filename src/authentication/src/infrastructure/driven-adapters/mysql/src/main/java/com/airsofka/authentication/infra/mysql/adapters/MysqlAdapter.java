package com.airsofka.authentication.infra.mysql.adapters;

import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.infra.mysql.entities.UserSql;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;
import com.airsofka.authentication.infra.mysql.utils.UserResponseMapper;
import jakarta.transaction.Transactional;
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
        userSql.setState(user.getState().getValue());
        userSql.setIsFrequent(user.getIsFrequent().getValue());
        userSql.setIsAuthenticated(user.getIsAuthenticated().getValue());
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
        userSql.setRole(user.getRole().getValue());
        userSql.setState(user.getState().getValue());
        userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
        userSql.setIsFrequent(user.getIsFrequent().getValue());
        userSql.setIsAuthenticated(user.getIsAuthenticated().getValue());
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
            return null;
        }
    }

    @Override
    @Transactional
    public void save(User user) {
        if(user.getIdentity().getValue() == null){
            throw new IllegalStateException("Identity cannot be null");
        }
        UserSql userSql = new UserSql(
          user.getIdentity().getValue(),
          user.getName().getValue(),
          user.getPassword() != null? user.getPassword().getValue() : null,
          user.getEmail().getValue(),
          user.getDocumentID()!= null? user.getDocumentID().getValue() : null,
          user.getPhoneNumber()!= null? user.getPhoneNumber().getValue() : null,
          user.getNacionality()!= null? user.getNacionality().getValue() : null,
          user.getMethodAuthentication().getValue(),
          user.getRole().getValue(),
          user.getState().getValue(),
          user.getIsFrequent().getValue(),
          user.getIsAuthenticated().getValue()
        );
        repository.save(userSql);
    }

    @Override
    @Transactional
    public void saveGoogle(User user) {
        if(user.getIdentity().getValue() == null){
            throw new IllegalStateException("Identity cannot be null");
        }
        UserSql userSql = new UserSql( user.getIdentity().getValue());
        userSql.setName(user.getName().getValue());
        userSql.setEmail(user.getEmail().getValue());
        userSql.setMethodAuthentication(user.getMethodAuthentication().getValue());
        userSql.setRole(user.getRole().getValue());
        userSql.setState(user.getState().getValue());
        userSql.setIsFrequent(user.getIsFrequent().getValue());
        userSql.setIsAuthenticated(user.getIsAuthenticated().getValue());
        repository.save(userSql);
    }

    @Override
    public void update(User user) {
        if(user.getIdentity().getValue() == null){
            throw new IllegalStateException("Identity cannot be null");
        }
        UserSql userSql = new UserSql(
          user.getIdentity().getValue(),
          user.getName().getValue(),
          user.getPassword() != null? passwordEncoder.encode(user.getPassword().getValue()) : null,
          user.getEmail().getValue(),
          user.getDocumentID()!= null? user.getDocumentID().getValue() : null,
          user.getPhoneNumber()!= null? user.getPhoneNumber().getValue() : null,
          user.getNacionality()!= null? user.getNacionality().getValue() : null,
          user.getMethodAuthentication().getValue(),
          user.getRole().getValue(),
          user.getState().getValue(),
          user.getIsFrequent().getValue(),
          user.getIsAuthenticated().getValue()
        );
        repository.save(userSql);
    }

    @Override
    public void updateAdmin(UserResponse user) {
        repository.findById(user.getId()).ifPresent(userSql -> {
            userSql.setName(user.getName());
            userSql.setIsAuthenticated(user.getAuthenticated());
            repository.save(userSql);
        });
    }
}
