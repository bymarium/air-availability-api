package com.airsofka.authentication.application.getbyemailuser;

import com.airsofka.shared.application.Request;

public class GetByEmailUserRequest extends Request {

    private final String email;

    protected GetByEmailUserRequest(String aggregateId, String email) {
        super(aggregateId);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
