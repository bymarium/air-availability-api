package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleRequest;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final RegisterUserGoogleUseCase registerUserGoogleUseCase;

    public SecurityConfig(RegisterUserGoogleUseCase registerUserGoogleUseCase) {
        this.registerUserGoogleUseCase = registerUserGoogleUseCase;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/**").permitAll()
                                .anyRequest().authenticated()
                ).
                formLogin(withDefaults())
                .oauth2Login(oauth -> oauth
                        .userInfoEndpoint(userInfo -> userInfo
                                .oidcUserService(this::processGoogleLogin)
                        )
                )
                .build();
    }


    private OidcUser processGoogleLogin(OidcUserRequest userRequest) {
        return registerUserGoogleUseCase.execute(new RegisterUserGoogleRequest(userRequest));
    }
}
