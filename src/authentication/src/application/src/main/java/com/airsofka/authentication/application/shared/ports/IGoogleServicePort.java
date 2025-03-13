package com.airsofka.authentication.application.shared.ports;

import com.airsofka.authentication.application.shared.users.UserGoogle;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public interface IGoogleServicePort {
    OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService();
    UserGoogle  getUserGoogle(OidcUserRequest oidcUserRequest);
    OidcUser getOidcUser(OidcUserRequest oidcUserRequest);
}
