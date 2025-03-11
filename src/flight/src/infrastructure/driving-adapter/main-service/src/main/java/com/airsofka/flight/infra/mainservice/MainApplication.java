package com.airsofka.flight.infra.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.airsofka.flight",
        "com.airsofka.infra.sql.repositories",
        "com.airsofka.infra.sql.adapters",

})
public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Starting main service");
        SpringApplication.run(MainApplication.class, args);
    }
}
