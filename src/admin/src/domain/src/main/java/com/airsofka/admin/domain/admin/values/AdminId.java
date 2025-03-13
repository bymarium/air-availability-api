package com.airsofka.admin.domain.admin.values;

import com.airsofka.shared.domain.generic.Identity;

public class AdminId extends Identity {
    public AdminId() {
        super();
    }

    private AdminId(String value) {
        super(value);
    }

    public static AdminId of(String value) {
        return new AdminId(value);
    }
}
