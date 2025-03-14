package com.airsofkaapi.booking.infra.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.airsofkaapi.booking","com.airsofkaapi.booking.infra.sql.adapters"})
public class MainApplication {
  public static void main(String[] args){
    SpringApplication.run(MainApplication.class, args);
  }
}