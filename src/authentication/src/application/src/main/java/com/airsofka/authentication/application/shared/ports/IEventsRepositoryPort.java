package com.airsofka.authentication.application.shared.ports;

import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventsRepositoryPort {
  Flux<DomainEvent> findAllAggregates();
  Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
  void save(DomainEvent domainEvent);
}
