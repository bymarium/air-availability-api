package com.airsofka.flight.application.shared.flight;

import com.airsofka.flight.domain.flight.Flight;

public class FlightMapper {
    public static FlightResponse mapToResponse(Flight flight) {
        return new FlightResponse(
                flight.getIdentity().getValue(),
                flight.getFlightNumber().getValue(),
                flight.getRouteId().getValue(),
                flight.getDepartureTime().getValue().toString(),
                flight.getArrivalTime().getValue().toString(),
                flight.getStatusFlight().getValue(),
                new FlightResponse.PricesInfo(
                        flight.getPrices().getAdultPrice(),
                        flight.getPrices().getChildPrice(),
                        flight.getPrices().getInfantPrice()
                ),
                flight.getSeats().stream().map(seat -> new FlightResponse.seat(
                        seat.getIdentity().getValue(),
                        seat.getSeatNumber().getValue(),
                        seat.getSeatClass().getValue(),
                        seat.getIsAvailable().getValue(),
                        seat.getPriceSeat().getValue()
                )).collect(java.util.stream.Collectors.toList())
        );
    }
}
