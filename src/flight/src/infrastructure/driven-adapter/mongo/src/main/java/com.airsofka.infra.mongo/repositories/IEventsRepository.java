package com.airsofka.infra.mongo.repositories;

import com.airsofka.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
    Mono<Event> findByDomainEventUuid(String uuid);

}
