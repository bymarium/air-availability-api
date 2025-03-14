package com.airsofka.admin.infra.mongo.adapters;

import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.admin.infra.mongo.entities.Event;
import com.airsofka.admin.infra.mongo.repositories.IEventsRepository;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

public class MongoAdapter implements IEventRepositoryPort {
    private final IEventsRepository eventsRepository;

    public MongoAdapter(IEventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    @Override
    public Flux<DomainEvent> findAllAggregates() {
        return eventsRepository.findAll().map(Event::getDomainEvent);
    }

    @Override
    public Flux<DomainEvent> findEventsByAggregateId(String aggregateId) {
        return findAllAggregates().filter(event -> event.getAggregateRootId().equals(aggregateId));
    }

    @Override
    public void save(DomainEvent domainEvent) {
        eventsRepository.save(new Event(domainEvent)).subscribe();
    }
}

