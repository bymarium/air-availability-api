package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.registeruser.RegisterUserUseCase;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleRequest;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import com.airsofka.authentication.application.shared.ports.IUserRepositoryPort;
import com.airsofka.authentication.infra.googleAuth.config.GoogleAuth;
import com.airsofka.authentication.infra.mysql.repositories.IUserRepository;
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

//    private final GoogleAuth googleAuth;
//    private final IUserRepository userRepository;
//    private final IUserRepositoryPort userRepositoryPort;

//    public SecurityConfig(IUserRepository userRepository, IUserRepositoryPort userRepositoryPort) {
//        this.userRepository = userRepository;
//        this.userRepositoryPort = userRepositoryPort;
//        this.googleAuth = new GoogleAuth(userRepository,userRepositoryPort);
//    }

    private final RegisterUserGoogleUseCase registerUserGoogleUseCase;

    public SecurityConfig(RegisterUserGoogleUseCase registerUserGoogleUseCase) {
        this.registerUserGoogleUseCase = registerUserGoogleUseCase;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("HOLA????????????????????????");
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
                                .oidcUserService(this::processGoogleLogin) // <-- aquí integras tu metodo
                        )
                )
                .build();
    }


    private OidcUser processGoogleLogin(OidcUserRequest userRequest) {
        return registerUserGoogleUseCase.execute(new RegisterUserGoogleRequest(userRequest));
    }
}
