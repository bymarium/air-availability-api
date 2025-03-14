package com.airsofka.authentication.infra.mainservice.config;

import com.airsofka.authentication.application.checkuserexists.CheckUserExistsRequest;
import com.airsofka.authentication.application.checkuserexists.CheckUserExistsUseCase;
import com.airsofka.authentication.application.loginusergoogle.LoginUserGoogleResponse;
import com.airsofka.authentication.application.loginusergoogle.LoginUserGoogleUseCase;
import com.airsofka.authentication.application.shared.users.UserGoogleRequest;
import com.airsofka.authentication.application.registerusergoogle.RegisterUserGoogleUseCase;
import jakarta.servlet.http.Cookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  private final RegisterUserGoogleUseCase registerUserGoogleUseCase;
  private final CheckUserExistsUseCase checkUserExistsUseCase;
  private final LoginUserGoogleUseCase loginUserGoogleUseCase;

  public SecurityConfig(RegisterUserGoogleUseCase registerUserGoogleUseCase, CheckUserExistsUseCase checkUserExistsUseCase, LoginUserGoogleUseCase loginUserGoogleUseCase) {
    this.registerUserGoogleUseCase = registerUserGoogleUseCase;
    this.checkUserExistsUseCase = checkUserExistsUseCase;
    this.loginUserGoogleUseCase = loginUserGoogleUseCase;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
      .csrf(AbstractHttpConfigurer::disable)
      .authorizeHttpRequests(authorize ->
        authorize
          .requestMatchers("/**").permitAll()
          .anyRequest().authenticated()
      )
      .oauth2Login(oauth -> oauth
        .userInfoEndpoint(userInfo -> userInfo
          .oidcUserService(this::processGoogleLogin)
        )
        .successHandler((request, response, authentication) -> {
          DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
          String token = (String) oidcUser.getAttributes().get("token");
          response.addCookie(generateCookie(token));
          if (token == null || token.isBlank()) {
            response.sendRedirect("http://localhost:4200/users/update/" + oidcUser.getEmail());
          } else {
            response.sendRedirect("http://localhost:4200");
          }
        })
        .failureHandler((request, response, exception) -> {
          response.sendRedirect("http://localhost:4200/error");
        })
      )
      .build();
  }

  private Cookie generateCookie(String token) {
    Cookie cookie = new Cookie("AUTH_TOKEN", token);
    cookie.setHttpOnly(false);
    cookie.setSecure(false);
    cookie.setPath("/");
    cookie.setMaxAge(60 * 60);
    return cookie;
  }

  private OidcUser processGoogleLogin(OidcUserRequest userRequest) {
    OidcIdToken idToken = userRequest.getIdToken();
    OidcUserInfo userInfo = new OidcUserInfo(idToken.getClaims());

    String email = userRequest.getIdToken().getEmail();
    boolean isUserExists = checkUserExistsUseCase.execute(new CheckUserExistsRequest(email));

    if (isUserExists) {
      return getOidcUserLogin(userRequest, idToken, userInfo);
    } else {
      return getOidcUserRegister(userRequest);
    }
  }

  private OidcUser getOidcUserRegister(OidcUserRequest userRequest) {
    OidcUser newUser = registerUserGoogleUseCase.execute(new UserGoogleRequest(userRequest));
    if (newUser == null) {
      throw new RuntimeException("No se pudo registrar el usuario");
    }
    return newUser;
  }

  private DefaultOidcUser getOidcUserLogin(OidcUserRequest userRequest, OidcIdToken idToken, OidcUserInfo userInfo) {
    LoginUserGoogleResponse loginResponse = loginUserGoogleUseCase.execute(new UserGoogleRequest(userRequest)).block();
    if(loginResponse != null) {
      Map<String, Object> attributes = new HashMap<>(idToken.getClaims());
      attributes.put("token", loginResponse.getToken());
      return new DefaultOidcUser(
        Collections.singleton(new SimpleGrantedAuthority("USER")),
        new OidcIdToken(idToken.getTokenValue(), idToken.getIssuedAt(), idToken.getExpiresAt(), attributes),
        userInfo,
        "sub"
      );
    } else {
      throw new RuntimeException("Error al iniciar sesión");
    }
  }
}
