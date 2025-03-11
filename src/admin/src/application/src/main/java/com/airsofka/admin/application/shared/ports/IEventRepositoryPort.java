package com.airsofka.admin.application.shared.ports;

import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public interface IEventRepositoryPort {
    Flux<DomainEvent> findAllAggregates();
    Flux<DomainEvent> findEventsByAggregateId(String aggregateId);
    void save(DomainEvent domainEvent);
}
