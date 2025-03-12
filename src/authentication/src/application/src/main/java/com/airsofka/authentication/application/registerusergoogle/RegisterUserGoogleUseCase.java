package com.airsofka.authentication.application.registerusergoogle;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IGoogleServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class RegisterUserGoogleUseCase implements ICommandUseCase<RegisterUserGoogleRequest, OidcUser> {

    private final IEventsRepositoryPort eventsRepositoryPort;
    private final IUserRepositoryPort userRepositoryPort;
    private final IGoogleServicePort googleServicePort;

    public RegisterUserGoogleUseCase(IEventsRepositoryPort eventsRepositoryPort, IUserRepositoryPort userRepositoryPort, IGoogleServicePort googleServicePort) {
        this.eventsRepositoryPort = eventsRepositoryPort;
        this.userRepositoryPort = userRepositoryPort;
        this.googleServicePort = googleServicePort;
    }

    @Override
    public OidcUser execute(RegisterUserGoogleRequest request) {
        UserGoogle userGoogle = googleServicePort.getUserGoogle(request.getUserRequest());
        User user = new User();
        user.registerGoogleUser(userGoogle.getName(), userGoogle.getEmail());
        user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
        user.markEventsAsCommitted();
        userRepositoryPort.registerGoogle(user);

        return googleServicePort.getOidcUser(request.getUserRequest());
    }
}
