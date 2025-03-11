package com.airsofka.authentication.application.shared.ports;

import com.airsofka.authentication.domain.user.User;

public interface IUserRepositoryPort {
    void register(User user);
}
