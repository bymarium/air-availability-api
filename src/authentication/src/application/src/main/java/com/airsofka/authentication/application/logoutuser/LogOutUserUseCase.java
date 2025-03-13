package com.airsofka.authentication.application.logoutuser;

import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Mono;

import java.util.Comparator;

public class LogOutUserUseCase implements ICommandUseCase<LogOutUserRequest,Mono<Boolean>> {
  private final IUserRepositoryPort userRepositoryPort;
  private final IEventsRepositoryPort eventsRepositoryPort;
  private final IJwtServicePort jwtServicePort;

  public LogOutUserUseCase(IUserRepositoryPort userRepositoryPort, IEventsRepositoryPort eventsRepositoryPort, IJwtServicePort jwtServicePort) {
    this.userRepositoryPort = userRepositoryPort;
    this.eventsRepositoryPort = eventsRepositoryPort;
    this.jwtServicePort = jwtServicePort;
  }

  @Override
  public Mono<Boolean> execute(LogOutUserRequest request) {
    System.out.println("TOKEN (case use):" + request.getToken());
    System.out.println("SUBJECT (case use):" + jwtServicePort.getSubject(request.getToken()));
    System.out.println("EMAIL (case use):" + jwtServicePort.getId(request.getToken()));
    UserResponse userResponse = userRepositoryPort.getByEmailUser(jwtServicePort.getSubject(request.getToken()));
    System.out.println("USER (case use):" + userResponse.getId());

     return eventsRepositoryPort.findEventsByAggregateId(userResponse.getId())
      .collectList()
      .map(events -> {
        events.sort(Comparator.comparing(DomainEvent::getWhen));
        User user = User.from(userResponse.getId(), events);
        user.loggedOutUser();
        user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
        user.markEventsAsCommitted();
        userRepositoryPort.save(user);

        return true;
      });
  }
}
