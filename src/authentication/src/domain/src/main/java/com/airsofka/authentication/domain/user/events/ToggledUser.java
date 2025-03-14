package com.airsofka.authentication.domain.user.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class ToggledUser extends DomainEvent {
    public ToggledUser() {
        super(EventsEnum.TOGGLED_USER.name());
    }
}
