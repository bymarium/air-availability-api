package com.airsofka.admin.infra.mongo.repositories;

import com.airsofka.admin.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
}
