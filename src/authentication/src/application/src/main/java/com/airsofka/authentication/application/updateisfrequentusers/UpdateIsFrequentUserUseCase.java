package com.airsofka.authentication.application.updateisfrequentusers;

import com.airsofka.authentication.application.loginuser.LoginUserResponse;
import com.airsofka.authentication.application.shared.ports.IEventsRepositoryPort;
import com.airsofka.authentication.application.shared.ports.IJwtServicePort;
import com.airsofka.authentication.application.shared.ports.IReservationAPIPort;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.application.shared.users.UserResponse;
import com.airsofka.authentication.domain.user.User;
import com.airsofka.shared.application.ICommandUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.airsofka.authentication.application.shared.users.UserMapper.mapperUserResponse;

public class UpdateIsFrequentUserUseCase implements ICommandUseCase<UpdateIsFrequentUserRequest, Mono<Void>> {
  private final IReservationAPIPort reservationAPIPort;
  private final IUserRepositoryPort userRepositoryPort;
  private final IEventsRepositoryPort eventsRepositoryPort;

  public UpdateIsFrequentUserUseCase(IReservationAPIPort reservationAPIPort, IUserRepositoryPort userRepositoryPort, IEventsRepositoryPort eventsRepositoryPort) {
    this.reservationAPIPort = reservationAPIPort;
    this.userRepositoryPort = userRepositoryPort;
    this.eventsRepositoryPort = eventsRepositoryPort;
  }

  @Override
  public Mono<Void> execute(UpdateIsFrequentUserRequest request) {
    List<UserResponse> users = userRepositoryPort.getAllUser();

    return Flux.fromIterable(users)
      .flatMap(userResponse ->
        eventsRepositoryPort.findEventsByAggregateId(userResponse.getId())
          .collectList()
          .flatMap(events ->
            reservationAPIPort.getReservationCounter(userResponse.getEmail())
              .map(counter -> {
                events.sort(Comparator.comparing(DomainEvent::getWhen));
                User user = User.from(userResponse.getId(), events);

                boolean isFrequent = user.getIsFrequent().getValue();
                user.updateIsFrequentUser(counter, request.getCounterFrequent());

                if(isFrequent != user.getIsFrequent().getValue()){
                  user.getUncommittedEvents().forEach(eventsRepositoryPort::save);
                  user.markEventsAsCommitted();
                  userRepositoryPort.save(user);
                }

                return user;
              })
          )
      )
      .then();
  }
}