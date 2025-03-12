package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.infra.googleAuth.adapters.GoogleAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleConfig {
    @Bean
    public GoogleAdapter googleAdapter (){
        return new GoogleAdapter();
    }
}
