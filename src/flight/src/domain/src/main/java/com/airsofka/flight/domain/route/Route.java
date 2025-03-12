package com.airsofka.flight.domain.route;

import com.airsofka.flight.domain.route.events.RouteCreated;
import com.airsofka.flight.domain.route.events.RouteDeleted;
import com.airsofka.flight.domain.route.events.RouteModified;
import com.airsofka.flight.domain.route.values.Destination;
import com.airsofka.flight.domain.route.values.Duration;
import com.airsofka.flight.domain.route.values.Origin;
import com.airsofka.flight.domain.route.values.RouteId;
import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.List;

public class Route extends AggregateRoot<RouteId> {
    private Origin origin;
    private Duration duration;
    private Destination destination;

    //#region Constructors

    public Route(String origin, Integer duration, String destination) {
        super(new RouteId());
        subscribe(new RouteHandler(this));
        apply(new RouteCreated(this.getIdentity().getValue(), origin, duration, destination));
    }

    private Route(RouteId identity) {
        super(identity);
        subscribe(new RouteHandler(this));
    }

    //#endregion


    //#region Getter & Setter

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    //#endregion

    //#region Domain Events

    public void removeRoute(String routeId) {
        apply(new RouteDeleted(routeId));
    }

    public void updateRoute(String origin, Integer duration, String destination) {
        apply(new RouteModified(this.getIdentity().getValue(), origin, duration, destination));
    }


    //#endregion

    //#region Public Methods

    // endregion

    //#region Private Methods

    // endregion

    //#region static Methods

    public static Route from(final String identity, final List<DomainEvent> events) {
        Route route = new Route(RouteId.of(identity));
        events.forEach(route::apply);
        return route;
    }

    // endregion
}