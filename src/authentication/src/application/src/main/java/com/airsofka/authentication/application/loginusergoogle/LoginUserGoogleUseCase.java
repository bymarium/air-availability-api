package com.airsofka.authentication.application.loginusergoogle;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IGoogleServicePort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserGoogle;
import com.airsofka.authentication.application.shared.users.UserGoogleRequest;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LoginUserGoogleUseCase implements ICommandUseCase<UserGoogleRequest, Mono<LoginUserGoogleResponse>> {
  private final IEventsRepositoryPort repository;
  private final IUserRepositoryPort userRepository;
  private final IGoogleServicePort googleService;
  private final IJwtServicePort jwtService;

  public LoginUserGoogleUseCase(IEventsRepositoryPort repository, IUserRepositoryPort userRepository, IGoogleServicePort googleService, IJwtServicePort jwtService) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.googleService = googleService;
    this.jwtService = jwtService;
  }

  @Override
  public Mono<LoginUserGoogleResponse> execute(UserGoogleRequest request) {
    UserGoogle userGoogle = googleService.getUserGoogle(request.getUserRequest());
    String id = userRepository.getByEmailUser(userGoogle.getEmail()).getId();

    return repository.findEventsByAggregateId(id)
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(id, events);
        user.authenticateGoogleUser(userGoogle.getEmail(), userGoogle.getName());
        user.getUncommittedEvents().forEach(repository::save);
        user.markEventsAsCommitted();
        userRepository.saveGoogle(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put("isFrequent", user.getIsFrequent().getValue());
        claims.put("role", user.getRole().getValue());
        String token = jwtService.createToken(user.getIdentity().getValue(), user.getEmail().getValue(), claims);

        return new LoginUserGoogleResponse(token, googleService.getOidcUser(request.getUserRequest()));
      });
  }
}
