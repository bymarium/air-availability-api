package com.airsofkaapi.booking.infra.mongo.repositories;

import com.airsofkaapi.booking.infra.mongo.entities.Event;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEventsRepository extends ReactiveMongoRepository<Event, String> {
}