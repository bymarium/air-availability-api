package com.airsofka.authentication.application.modifyuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.Comparator;

import static com.airsofka.authentication.application.shared.users.UserMapper.mapperUserResponse;

public class ModifyUserUseCase implements ICommandUseCase<ModifyUserRequest, Mono<UserResponse>> {
  private final IEventsRepositoryPort eventsRepositoryPort;
  private final IUserRepositoryPort userRepositoryPort;
  private final IJwtServicePort jwtServicePort;

  public ModifyUserUseCase(IEventsRepositoryPort eventsRepositoryPort, IUserRepositoryPort userRepositoryPort, IJwtServicePort jwtServicePort) {
    this.eventsRepositoryPort = eventsRepositoryPort;
    this.userRepositoryPort = userRepositoryPort;
    this.jwtServicePort = jwtServicePort;
  }

  @Override
  public Mono<UserResponse> execute(ModifyUserRequest request) {
    UserResponse userResponse = userRepositoryPort.getByEmailUser(jwtServicePort.getSubject(request.getToken()));

    return eventsRepositoryPort.findEventsByAggregateId(userResponse.getId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(userResponse.getId(), events);
        user.modifyUser(
          request.getName(),
          user.getEmail().getValue(),
          request.getPassword(),
          user.getDocumentID().getValue(),
          request.getPhoneNumber(),
          request.getNacionality()
        );

        user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
        user.markEventsAsCommitted();
        userRepositoryPort.update(user);

        return mapperUserResponse(user);
      });
  }
}
