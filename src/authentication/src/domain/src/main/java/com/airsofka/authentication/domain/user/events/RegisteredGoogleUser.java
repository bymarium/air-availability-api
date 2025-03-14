package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class RegisteredGoogleUser extends DomainEvent {
    private String fullName;
    private String email;

    public RegisteredGoogleUser() {
        super(EventsEnum.REGISTERED_GOOGLE_USER.name());
    }

    public RegisteredGoogleUser(String fullName, String email) {
        super(EventsEnum.REGISTERED_GOOGLE_USER.name());
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
