package com.airsofka.flight.domain.flight;

import com.airsofka.flight.domain.flight.events.AssignedRoute;
import com.airsofka.flight.domain.flight.events.FlightCreated;
import com.airsofka.flight.domain.flight.events.FlightRemoved;
import com.airsofka.flight.domain.flight.events.RouteChanged;
import com.airsofka.flight.domain.flight.events.SeatChanged;
import com.airsofka.flight.domain.flight.events.SeatEnabled;
import com.airsofka.flight.domain.flight.events.StatusChanged;
import com.airsofka.flight.domain.flight.events.UpdateFlight;
import com.airsofka.flight.domain.flight.values.ArrivalTime;
import com.airsofka.flight.domain.flight.values.DepartureTime;
import com.airsofka.flight.domain.flight.values.FlightNumber;
import com.airsofka.flight.domain.flight.values.IsAvailable;
import com.airsofka.flight.domain.flight.values.Prices;
import com.airsofka.flight.domain.flight.values.RouteId;
import com.airsofka.flight.domain.flight.values.StatusFlight;
import com.airsofka.flight.domain.flight.values.TotalSeats;
import com.airsofka.shared.domain.generic.DomainActionsContainer;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.Date;
import java.util.function.Consumer;

public class FlightHandler extends DomainActionsContainer {
    public FlightHandler(Flight flight) {
        addAction(createFlight(flight));
        addAction(removeFlight(flight));
        addAction(assingRoute(flight));
        addAction(changedRoute(flight));
        addAction(changedSeat(flight));
        addAction(changeStatusFlight(flight));
        addAction(updateFlight(flight));
    }

    public Consumer<? extends DomainEvent> createFlight(Flight flight) {
        return (FlightCreated event) -> {
            flight.setFlightNumber(FlightNumber.of(event.getFlightNumber()));
            flight.setTotalSeats(TotalSeats.of(184));
           flight.setSeats(flight.initializeSeats());
            System.out.println(flight.getSeats().size());
            flight.setStatusFlight(StatusFlight.of("Ready"));
            flight.setPrices(Prices.of(event.getPrice()));
            if (event.getRouteId() != null) {
                flight.setRouteId(RouteId.of(event.getRouteId()));
            }
            if (event.getDepartureTime().before(event.getArrivalTime())) {
                flight.setDepartureTime(DepartureTime.of(event.getDepartureTime()));
                flight.setArrivalTime(ArrivalTime.of(event.getArrivalTime()));
            }


        };

    }

    public Consumer<? extends DomainEvent> removeFlight(Flight flight) {
        return (FlightRemoved event) -> {
            flight.removeFlight(event.getFlightId());
            flight.getSeats().clear();
            flight.initializeSeats();
        };
    }

    public Consumer<? extends DomainEvent> assingRoute(Flight flight) {
        return (AssignedRoute event) -> {
            System.out.println("asdasdadasdadasd:"+event.getRouteId());
            if (event.getRouteId() != null) {
                flight.setRouteId(RouteId.of(event.getRouteId()));
            }else {
                throw new IllegalArgumentException("RouteId cannot be null.");
            }
        };
    }

    public Consumer<? extends DomainEvent> changedRoute(Flight flight) {
        return (RouteChanged event) -> {
            if (flight.getRouteId() != null) {
                flight.setRouteId(RouteId.of(event.getRouteId()));
            }else {
                throw new IllegalArgumentException("RouteId cannot be null.");
            }
        };
    }

    public Consumer<? extends DomainEvent> changedSeat(Flight flight) {
        return (SeatChanged event) -> {
            if (flight.getSeatById(event.getSeatId()) != null) {
                flight.getSeatById(event.getSeatId()).setIsAvailable(IsAvailable.of(false));
            }
        };
    }

    public Consumer<? extends DomainEvent> changeStatusFlight(Flight flight) {
        return (StatusChanged event) -> {
            if (flight.getStatusFlight() != null) {
                flight.setStatusFlight(StatusFlight.of(event.getStatus()));
            }
            if (event.getStatus().equals("Maintenance") || event.getStatus().equals("Cancelled") || event.getStatus().equals("Out of Service")) {
                flight.setDepartureTime(DepartureTime.of(new Date()));
                flight.setArrivalTime(ArrivalTime.of(new Date()));
            }
        };
    }

    public Consumer<? extends DomainEvent> updateFlight(Flight flight) {
        return (UpdateFlight event) -> {
            if(flight.getDepartureTime().getValue().after(event.getArrivalTime())){
                throw new IllegalArgumentException("Departure time cannot be after arrival time.");
            }
            flight.setDepartureTime(DepartureTime.of(event.getDepartureTime()));
            flight.setArrivalTime(ArrivalTime.of(event.getArrivalTime()));

        };
    }

    public Consumer<? extends DomainEvent> enableSeat(Flight flight) {
        return (SeatEnabled event) -> {
            if (flight.getSeatById(event.getSeatId()) == null) {
                throw new IllegalArgumentException("Seat not found.");
            }
            flight.getSeatById(event.getSeatId()).setIsAvailable(IsAvailable.of(true));
        };
    }
}
