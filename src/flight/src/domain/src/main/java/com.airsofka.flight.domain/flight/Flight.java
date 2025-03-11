package com.airsofka.flight.domain.flight;

import com.airsofka.flight.domain.flight.entities.Seat;
import com.airsofka.flight.domain.flight.events.AssignedRoute;
import com.airsofka.flight.domain.flight.events.FlightCreated;
import com.airsofka.flight.domain.flight.events.FlightRemoved;
import com.airsofka.flight.domain.flight.events.RouteChanged;
import com.airsofka.flight.domain.flight.events.SeatChanged;
import com.airsofka.flight.domain.flight.events.SeatEnabled;
import com.airsofka.flight.domain.flight.events.StatusChanged;
import com.airsofka.flight.domain.flight.events.UpdateFlight;

import com.airsofka.flight.domain.flight.values.*;
import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Flight extends AggregateRoot<FlightId> {
    private FlightNumber flightNumber;
    private FlightModel flightModel;
    private RouteId routeId;
    private DepartureTime departureTime;
    private ArrivalTime arrivalTime;
    private Prices prices;
    private TotalSeats totalSeats;
    private List<Seat> seats;
    private StatusFlight statusFlight;

    //#region Constructors

    public Flight(String flightNumber, String routeId, Double price, Date departureTime, Date arrivalTime,String flightModel) {
        super(new FlightId());
        subscribe(new FlightHandler(this));
        apply(new FlightCreated(this.getIdentity().getValue(), flightNumber, flightModel,routeId,price, departureTime, arrivalTime));
    }

    private Flight(FlightId identity) {
        super(identity);
        subscribe(new FlightHandler(this));
    }
    //#endregion
    //#region Getter & Setter


    public FlightModel getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(FlightModel flightModel) {
        this.flightModel = flightModel;
    }

    public FlightNumber getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(FlightNumber flightNumber) {
        this.flightNumber = flightNumber;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }

    public ArrivalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(ArrivalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public TotalSeats getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(TotalSeats totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public StatusFlight getStatusFlight() {
        return statusFlight;
    }

    public void setStatusFlight(StatusFlight statusFlight) {
        this.statusFlight = statusFlight;
    }

    public RouteId getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteId routeId) {
        this.routeId = routeId;
    }

    //#endregion
    //#region Domain Events
    public void removeFlight(String flightId) {
        apply(new FlightRemoved(flightId));
    }

    public void assingRoute( String routeId) {
        apply(new AssignedRoute(routeId));
    }

    public void changeRoute(String routeId) {
        apply(new RouteChanged(this.getIdentity().getValue(), routeId));
    }

    public void changedSeat( String seatId) {
        apply(new SeatChanged(this.getIdentity().getValue(), seatId));
    }

    public void changeStatusFlight( String status) {
        apply(new StatusChanged(this.getIdentity().getValue(), status));
    }

    public void updateFlight( String flightNumber, String routeId, String seatId,Date departureTime, Date arrivalTime, Double price) {
        apply(new UpdateFlight(this.getIdentity().getValue(), flightNumber, routeId, seatId, departureTime, arrivalTime, price));
    }
    public void enableSeat(String seatId) {
        apply(new SeatEnabled(seatId));
    }

    //#endregion

    //#region public methods
    public List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= 33; row++) {
            if (row >= 12 && row <= 16) {
                continue;
            }
            String[] columns = getColumnsByRow(row);
            SeatInfo info = getSeatClassAndPrice(row);
            for (String column : columns) {
                seats.add(new Seat(
                        SeatId.of(String.format("%s-%s", row, column)),
                        SeatNumber.of(String.format("%s-%s", row, column)),
                        SeatClass.of(info.getSeatClass()),
                        IsAvailable.of(true),
                        PriceSeat.of(info.getPrice()),
                        LocationSeat.of(row, column)
                ));
            }
        }
        return seats;
    }

    private String[] getColumnsByRow(int row) {
        if (row >= 1 && row <= 4) {
            return new String[]{"A", "B", "E", "F"};
        } else {
            return new String[]{"A", "B", "C", "D", "E", "F"};
        }
    }

    private SeatInfo getSeatClassAndPrice(int row) {
        return switch (row) {
            case 1, 2, 3, 4 -> new SeatInfo("Business Class", getPrices().getStandardPrice()*0.40);
            case 5, 6, 7, 8 -> new SeatInfo("Economy Extra", getPrices().getStandardPrice()*0.30);
            case 9, 10, 11, 19, 20 -> new SeatInfo("Favorable", getPrices().getStandardPrice()*0.20);
            case 17, 18 -> new SeatInfo("Exit", getPrices().getStandardPrice()*0.25);
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 -> new SeatInfo("Regular", getPrices().getStandardPrice()*0.1);
            default -> throw new IllegalArgumentException("row no available: " + row);
        };
    }
    public Seat getSeatById(String seatId) {
        return seats.stream().filter(seat -> seat.getIdentity().getValue().equals(seatId)).findFirst().orElse(null);
    }

    //#endregion
    //#region static methods
    public static Flight from(final String identity, final List<DomainEvent> events) {
        Flight flight = new Flight(FlightId.of(identity));
        events.forEach(flight::apply);
        return flight;
    }
    //#endregion
}
