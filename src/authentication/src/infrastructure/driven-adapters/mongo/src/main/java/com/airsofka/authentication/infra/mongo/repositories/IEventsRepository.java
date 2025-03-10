package com.airsofka.authentication.infra.mongo.repositories;

import com.airsofka.authentication.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
}
