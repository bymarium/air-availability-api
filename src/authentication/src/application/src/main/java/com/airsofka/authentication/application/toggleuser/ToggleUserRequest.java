package com.airsofka.authentication.application.toggleuser;

import com.airsofka.shared.application.Request;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToggleUserRequest extends Request {
    private final String email;

    public ToggleUserRequest(@JsonProperty("email") String email) {
        super(email);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

