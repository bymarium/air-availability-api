package com.airsofka.admin.infra.mainservice.consumer;

import com.airsofka.admin.application.shared.consumerservices.BookingService;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    private final BookingService bookingService;

    public BookingConsumer(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RabbitListener(queues = "booking_queue")
    public void receiveMessage(BookingEntity bookingEntity) {
        System.out.println("Received message " + bookingEntity);
        bookingService.saveBookingState(bookingEntity.getId(), bookingEntity.getState());

    }
}
