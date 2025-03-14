package com.airsofka.admin.infra.mainservice.consumer;

import com.airsofka.admin.infra.mysql.consumerservices.BookingAdapter;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookingConsumer {

    private final BookingAdapter bookingAdapter;

    public BookingConsumer(BookingAdapter bookingAdapter) {
        this.bookingAdapter = bookingAdapter;
    }

    @RabbitListener(queues = "booking_queue")
    public void receiveMessage(BookingEntity bookingEntity) {
        System.out.println("Received message " + bookingEntity);
        bookingAdapter.updateStatus(bookingEntity);

    }
}
