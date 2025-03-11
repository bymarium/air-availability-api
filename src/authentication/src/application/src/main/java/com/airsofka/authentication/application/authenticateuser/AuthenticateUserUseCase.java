package com.airsofka.authentication.application.authenticateuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.Comparator;

public class AuthenticateUserUseCase implements ICommandUseCase<AuthenticateUserRequest, Mono<AuthenticateUserResponse>> {
  private final IEventsRepositoryPort repository;
  private final IUserRepositoryPort userRepository;
  private final IJwtServicePort jwtService;

  public AuthenticateUserUseCase(IEventsRepositoryPort repository, IUserRepositoryPort userRepository, IJwtServicePort jwtService) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.jwtService = jwtService;
  }

  @Override
  public Mono<AuthenticateUserResponse> execute(AuthenticateUserRequest request) {
    return repository.findEventsByAggregateId(request.getAggregateId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));

        User user = User.from(request.getAggregateId(), events);
        user.authenticateUser(request.getEmail(), request.getPassword());
        user.getUncommittedEvents().forEach(repository::save);
        user.markEventsAsCommitted();

        userRepository.save(user);

        String token = jwtService.createToken(user.getIdentity().getValue(), user.getEmail().getValue());
        return new AuthenticateUserResponse(user.getEmail().getValue(), user.getIsAuthenticated().getValue(), token);
      });
  }
}
