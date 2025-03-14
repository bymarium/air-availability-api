package com.airsofka.authentication.application.toggleuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.authentication.domain.user.values.UserId;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
public class ToggleUserUseCase implements ICommandUseCase<ToggleUserRequest, Mono<Boolean>> {

  private final IUserRepositoryPort userRepositoryPort;
  private final IEventsRepositoryPort eventsRepositoryPort;

  public ToggleUserUseCase(IUserRepositoryPort userRepositoryPort, IEventsRepositoryPort eventsRepositoryPort) {
    this.userRepositoryPort = userRepositoryPort;
    this.eventsRepositoryPort = eventsRepositoryPort;
  }

  @Override
  public Mono<Boolean> execute(ToggleUserRequest request) {
    return Mono.fromSupplier(() -> userRepositoryPort.getByEmailUser(request.getEmail()))
      .flatMap(userResponse -> {
        if (userResponse == null) {
          return Mono.just(false);
        }

        String userId = userResponse.getId();

        return eventsRepositoryPort.findEventsByAggregateId(userId)
          .collectList()
          .map(events -> {
            events.sort(Comparator.comparing(DomainEvent::getWhen));
            User user = User.from(userId, events);
            user.toggleUser();
            user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
            user.markEventsAsCommitted();
            userRepositoryPort.save(user);
            return true;
          });
      });
  }
}