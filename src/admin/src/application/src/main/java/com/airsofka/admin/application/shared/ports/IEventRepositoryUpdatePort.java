package com.airsofka.admin.application.shared.ports;

import com.airsofka.admin.domain.admin.entities.Booking;

public interface IEventRepositoryUpdatePort {
    void updateStatus(Booking booking);
}
