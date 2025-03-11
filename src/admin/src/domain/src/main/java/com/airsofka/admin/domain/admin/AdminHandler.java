package com.airsofka.admin.domain.admin;

import com.airsofka.admin.domain.admin.events.CanceledBooking;
import com.airsofka.admin.domain.admin.events.ConfirmedBooking;
import com.airsofka.admin.domain.admin.events.GeneratedAnalytics;
import com.airsofka.admin.domain.admin.events.IssuedBooking;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class AdminHandler extends DomainActionsContainer {

    public AdminHandler(Admin admin) {
        addAction(cancelBooking(admin));
        addAction(confirmBooking(admin));
        addAction(GenerateAnalytics(admin));
        addAction(issueBooking(admin));
    }

    public Consumer<? extends DomainEvent> cancelBooking(Admin admin) {
        return (CanceledBooking event) -> {
        };
    }

    public Consumer<? extends DomainEvent> confirmBooking(Admin admin) {
        return (ConfirmedBooking event) -> {
        };
    }

    public Consumer<? extends DomainEvent> GenerateAnalytics(Admin admin) {
        return (GeneratedAnalytics event) -> {
        };
    }

    public Consumer<? extends DomainEvent> issueBooking(Admin admin) {
        return (IssuedBooking event) -> {
        };
    }

}
