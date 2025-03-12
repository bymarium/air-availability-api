package com.airsofka.authentication.infra.googleAuth.adapters;


import com.airsofka.authentication.application.shared.users.UserGoogle;
import com.airsofka.authentication.application.shared.ports.IGoogleServicePort;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public class GoogleAdapter implements IGoogleServicePort {

    @Override
    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        return userRequest -> {
            return new OidcUserService().loadUser(userRequest);
        };
    }

    @Override
    public UserGoogle getUserGoogle(OidcUserRequest oidcUserRequest){
        OidcUser oidcUser = new OidcUserService().loadUser(oidcUserRequest);
        return new UserGoogle(oidcUser.getFullName(),oidcUser.getEmail());
    }

    @Override
    public OidcUser getOidcUser(OidcUserRequest oidcUserRequest){
        return new OidcUserService().loadUser(oidcUserRequest);
    }

}
