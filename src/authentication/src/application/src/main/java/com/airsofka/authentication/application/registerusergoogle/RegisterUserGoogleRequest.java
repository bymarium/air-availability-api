package com.airsofka.authentication.application.registerusergoogle;

import com.airsofka.shared.application.Request;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;

public class RegisterUserGoogleRequest extends Request {

    private OidcUserRequest userRequest;

    public RegisterUserGoogleRequest(OidcUserRequest userRequest) {
        super(null);
        this.userRequest = userRequest;
    }

    public OidcUserRequest getUserRequest() {
        return userRequest;
    }
}
