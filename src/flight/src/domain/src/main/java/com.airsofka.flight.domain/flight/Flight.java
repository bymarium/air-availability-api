package com.airsofka.flight.domain.flight;

import com.airsofka.flight.domain.flight.entities.Seat;
import com.airsofka.flight.domain.flight.events.FlightCreated;
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
}
