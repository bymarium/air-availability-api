package com.airsofka.flight.domain.flight;

import com.airsofka.flight.domain.flight.entities.Seat;
import com.airsofka.flight.domain.flight.events.FlightCreated;
import com.airsofka.flight.domain.flight.events.FlightRemoved;
import com.airsofka.flight.domain.flight.values.ArrivalTime;
import com.airsofka.flight.domain.flight.values.DepartureTime;
import com.airsofka.flight.domain.flight.values.FlightId;
import com.airsofka.flight.domain.flight.values.FlightNumber;
import com.airsofka.flight.domain.flight.values.IsAvailable;
import com.airsofka.flight.domain.flight.values.PriceSeat;
import com.airsofka.flight.domain.flight.values.Prices;
import com.airsofka.flight.domain.flight.values.SeatClass;
import com.airsofka.flight.domain.flight.values.SeatId;
import com.airsofka.flight.domain.flight.values.SeatInfo;
import com.airsofka.flight.domain.flight.values.SeatNumber;
import com.airsofka.flight.domain.flight.values.StatusFlight;
import com.airsofka.flight.domain.flight.values.TotalSeats;
import com.airsofka.shared.domain.generic.AggregateRoot;
import com.airsofka.shared.domain.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;


public class Flight extends AggregateRoot<FlightId> {
    private FlightNumber flightNumber;
    private DepartureTime departureTime;
    private ArrivalTime arrivalTime;
    private Prices prices;
    private TotalSeats totalSeats;
    private List<Seat> seats;
    private StatusFlight statusFlight;

    //#region Constructors
    private Flight(FlightId identity, FlightNumber flightNumber, DepartureTime departureTime, ArrivalTime arrivalTime, Prices prices, TotalSeats totalSeats, List<Seat> seats, StatusFlight statusFlight) {
        super(identity);
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.prices = prices;
        this.totalSeats = totalSeats;
        this.seats = seats;
        this.statusFlight = statusFlight;
    }

    public Flight(FlightId identity, FlightNumber flightNumber) {
        super(new FlightId());
//        subscribe(new FlightHandler(this));
        apply(new FlightCreated(identity.getValue(), flightNumber.getValue()));
        this.flightNumber = flightNumber;
    }
    //#endregion
    //#region Getter & Setter

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

    //#endregion
    //#region Domain Events
    public void RemoveFlight(String flightId) {
        apply(new FlightRemoved(flightId));
    }
    //#endregion

    //#region public methods
    private List<Seat> initializeSeats() {
        List<Seat> seats = new ArrayList<>();
        for (int row = 1; row <= 33; row++) {
            for (int seatNumberInRow = 1; seatNumberInRow <= 6; seatNumberInRow++) {
                if (row >= 12 && row <= 16) {
                    continue;
                }

                SeatInfo info = getSeatClassAndPrice(row);
                seats.add(new Seat(
                        SeatId.of(String.format("%s-%s", row, seatNumberInRow)),
                        SeatNumber.of(String.format("%s-%s", row, seatNumberInRow)),
                        SeatClass.of(info.getSeatClass()),
                        IsAvailable.of(true),
                        PriceSeat.of(info.getPrice())
                ));
            }
        }
        return seats;
    }
    private SeatInfo  getSeatClassAndPrice(int row) {
        return switch (row) {
            case 1, 2, 3, 4 -> new SeatInfo("Business Class", 150.0);
            case 5, 6, 7, 8 -> new SeatInfo("Economy Extra", 120.0);
            case 9, 10, 11, 19, 20 -> new SeatInfo("Favorable", 100.0);
            case 17, 18 -> new SeatInfo("Exit", 130.0);
            case 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33 -> new SeatInfo("Regular", 80.0);
            default -> throw new IllegalArgumentException("row no available: " + row);
        };
    }

    //#endregion
    //#region static methods
    public static Flight from(final String identity, final List<DomainEvent> events){
        Flight flight = new Flight(FlightId.of(identity), FlightNumber.of(events.get(0).getName()));
        events.forEach(flight::apply);
        return flight;
    }
    //#endregion
}
