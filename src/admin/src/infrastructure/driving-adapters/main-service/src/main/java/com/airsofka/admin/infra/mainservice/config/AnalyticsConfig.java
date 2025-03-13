package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.infra.mysql.adapters.AnalyticsAdapter;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration


public class AnalyticsConfig {
    @Bean
    AnalyticsAdapter analyticsAdapter(BookingJpaRepository bookingJpaRepository){
        return new AnalyticsAdapter(bookingJpaRepository);
    }
}
