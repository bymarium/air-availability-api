package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.infra.mysql.adapters.MysqlAdapter;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.airsofka.admin.infra.mysql.repositories")
@EntityScan(basePackages = "com.airsofka.admin.infra.mysql.entities")
public class SqlConfig {
    @Bean
    public MysqlAdapter mysqlAdapter(BookingJpaRepository bookingJpaRepository){
        return new MysqlAdapter(bookingJpaRepository);
    }
}
