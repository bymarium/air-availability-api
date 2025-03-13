package com.airsofka.authentication.application.shared.users;

import com.airsofka.shared.application.Request;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;

public class UserGoogleRequest extends Request {

    private OidcUserRequest userRequest;

    public UserGoogleRequest(OidcUserRequest userRequest) {
        super(null);
        this.userRequest = userRequest;
    }

    public OidcUserRequest getUserRequest() {
        return userRequest;
    }
}
