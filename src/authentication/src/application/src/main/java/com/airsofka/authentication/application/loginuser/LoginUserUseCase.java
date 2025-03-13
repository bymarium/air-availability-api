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
    return repository.findEventsByAggregateId(userResponse.getId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(userResponse.getId(), events);
        System.out.println("USER PW (case use):" + user.getPassword().getValue());
        System.out.println("REQUEST PW (case use):" + request.getPassword());
        System.out.println("MATCHES (case use):" + user.getPassword().getValue().equals(request.getPassword()));
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
