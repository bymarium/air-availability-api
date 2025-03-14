package com.airsofkaapi.booking.infra.mongo.adapters;


import com.airsofka.shared.domain.generic.DomainEvent;
import com.airsofkaapi.booking.application.shared.ports.IEventsRepositoryPort;
import com.airsofkaapi.booking.infra.mongo.entities.Event;
import com.airsofkaapi.booking.infra.mongo.repositories.IEventsRepository;
import reactor.core.publisher.Flux;

public class MongoAdapter implements IEventsRepositoryPort {
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