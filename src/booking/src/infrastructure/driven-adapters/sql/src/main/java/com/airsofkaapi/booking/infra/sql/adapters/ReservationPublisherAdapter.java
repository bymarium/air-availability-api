package com.airsofkaapi.booking.infra.sql.adapters;

import com.airsofkaapi.booking.application.shared.reservation.ReservationResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Component
public class ReservationPublisherAdapter {
  private final RabbitTemplate rabbitTemplate;
  private final Scheduler scheduler = Schedulers.boundedElastic();

  @Value("${rabbitmq.queue}")
  private String queue;

  public ReservationPublisherAdapter(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public Mono<Void> publishReservation(ReservationResponse reservation) {
    return Mono.fromCallable(() -> {
        rabbitTemplate.convertAndSend(queue, reservation);
        return true;
      })
      .subscribeOn(scheduler)
      .then();
  }
}
