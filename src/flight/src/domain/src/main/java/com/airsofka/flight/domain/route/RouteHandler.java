package com.airsofka.flight.domain.route;

import com.airsofka.flight.domain.route.events.RouteCreated;
import com.airsofka.flight.domain.route.values.Destination;
import com.airsofka.flight.domain.route.values.Duration;
import com.airsofka.flight.domain.route.values.Origin;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.function.Consumer;

public class RouteHandler extends DomainActionsContainer {
    public RouteHandler(Route route) {
        addAction(createRoute(route));
    }

    public Consumer<? extends DomainEvent> createRoute(Route route) {
        return (RouteCreated event) -> {
            route.setOrigin(Origin.of(event.getOrigin()));
            route.setDuration(Duration.of(event.getDuration()));
            route.setDestination(Destination.of(event.getDestination()));
        };

    }

}