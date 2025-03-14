package com.airsofka.authentication.application.loginuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LoginUserUseCase implements ICommandUseCase<LoginUserRequest, Mono<LoginUserResponse>> {
  private final IEventsRepositoryPort repository;
  private final IUserRepositoryPort userRepository;
  private final IJwtServicePort jwtService;

  public LoginUserUseCase(IEventsRepositoryPort repository, IUserRepositoryPort userRepository, IJwtServicePort jwtService) {
    this.repository = repository;
    this.userRepository = userRepository;
    this.jwtService = jwtService;
  }

  @Override
  public Mono<LoginUserResponse> execute(LoginUserRequest request) {
    UserResponse userResponse = userRepository.getByEmailUser(request.getEmail());

    if(userResponse.getRole().equals("ADMIN")){
      Map<String, Object> claims = new HashMap<>();
      userResponse.setAuthenticated(true);
      userRepository.updateAdmin(userResponse);
      String token = jwtService.createToken(userResponse.getId(), userResponse.getEmail(), claims);
      return Mono.just(new LoginUserResponse(token));
    }

    return repository.findEventsByAggregateId(userResponse.getId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(userResponse.getId(), events);
        user.authenticateUser(request.getEmail(), request.getPassword());
        user.getUncommittedEvents().forEach(repository::save);
        user.markEventsAsCommitted();

        userRepository.save(user);

        Map<String, Object> claims = new HashMap<>();
        claims.put("isFrequent", user.getIsFrequent().getValue());
        claims.put("role", user.getRole().getValue());

        String token = jwtService.createToken(user.getIdentity().getValue(), user.getEmail().getValue(), claims);
        return new LoginUserResponse(token);
      });
  }
}
