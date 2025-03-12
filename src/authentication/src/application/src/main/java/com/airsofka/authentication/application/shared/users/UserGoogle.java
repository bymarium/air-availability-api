package com.airsofka.authentication.application.shared.users;

public class UserGoogle {

    private final String name;
    private final String email;

    public UserGoogle(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
