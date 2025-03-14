package com.airsofka.authentication.application.modifyuserasadmin;

import com.airsofka.authentication.application.registeruser.RegisterUserRequest;
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

public class ModifyUserAsAdminUseCase implements ICommandUseCase<ModifyUserAsAdminRequest, Mono<UserResponse>> {
  private final IEventsRepositoryPort eventsRepositoryPort;
  private final IUserRepositoryPort userRepositoryPort;

  public ModifyUserAsAdminUseCase(IEventsRepositoryPort eventsRepositoryPort, IUserRepositoryPort userRepositoryPort) {
    this.eventsRepositoryPort = eventsRepositoryPort;
    this.userRepositoryPort = userRepositoryPort;
  }


  @Override
  public Mono<UserResponse> execute(ModifyUserAsAdminRequest request) {
    UserResponse userResponse = userRepositoryPort.getByEmailUser(request.getOriginalEmail());

    return eventsRepositoryPort.findEventsByAggregateId(userResponse.getId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(userResponse.getId(), events);
        user.modifyUser(
          request.getFullName(),
          request.getEmail(),
          request.getPassword(),
          request.getDocumentId(),
          request.getPhoneNumber(),
          request.getNacionality()
        );

        user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
        user.markEventsAsCommitted();
        userRepositoryPort.save(user);

        return mapperUserResponse(user);
      });
  }
}
