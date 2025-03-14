package com.airsofka.flight.application.shared.ports;


import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import com.airsofka.flight.domain.flight.Flight;

import java.util.List;

public interface IFlightRepositoryPort {
    void saveFlight(Flight flight);

    void updateFlight(Flight flight);

    List<FlightListResponse> findAll();

    FlightListResponse findById(String aggregateId);

    void updateStatus(Flight flight);

    void changeRoute(Flight flight);

    void changeSeat(String aggregateId, String seatId);

    void enableSeat(String aggregateId, String seatId);

    void removeFlight(String aggregateId);

    SeatResponse findSeatsById(String aggregateId);

    List<FlightResponse> findAllReseponse();
}
