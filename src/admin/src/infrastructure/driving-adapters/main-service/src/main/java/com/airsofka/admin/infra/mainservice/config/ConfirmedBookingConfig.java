package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.infra.mysql.adapters.ConfirmedBookingAdapter;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfirmedBookingConfig {
    @Bean
    public ConfirmedBookingAdapter confirmedBookingAdapter(BookingJpaRepository bookingJpaRepository){
        return new ConfirmedBookingAdapter(bookingJpaRepository);
    }
}
