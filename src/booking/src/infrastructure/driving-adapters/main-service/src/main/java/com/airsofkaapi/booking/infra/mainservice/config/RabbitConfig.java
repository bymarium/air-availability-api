package com.airsofkaapi.booking.infra.mainservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
  @Value("${rabbitmq.queue}")
  private String queue;

  @Value("${spring.rabbitmq.addresses}")
  private String uri;

  @Bean
  public Queue queue() {
    return new Queue(queue);
  }

  @Bean
  public ConnectionFactory rabbitConnectionFactory() throws Exception {
    CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    connectionFactory.setUri(uri);
    return connectionFactory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    return rabbitTemplate;
  }

  @Bean
  public Jackson2JsonMessageConverter messageConverter(){
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    return new Jackson2JsonMessageConverter(objectMapper);
  }
}
