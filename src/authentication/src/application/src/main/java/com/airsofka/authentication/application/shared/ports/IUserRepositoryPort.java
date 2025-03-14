package com.airsofka.authentication.application.shared.ports;

import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import java.util.List;

public interface IUserRepositoryPort {
    void register(User user);
    void registerGoogle(User user);
    List<UserResponse> getAllUser();
    UserResponse getByEmailUser(String email);
    void save(User user);
    void saveGoogle(User user);
    Boolean matches(String password, String encodedPassword);
}
