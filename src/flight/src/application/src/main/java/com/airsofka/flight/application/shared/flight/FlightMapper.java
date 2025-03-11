package com.airsofka.flight.application.shared.flight;

import com.airsofka.flight.domain.flight.Flight;

import java.util.stream.Collectors;

public class FlightMapper {
    public static FlightResponse mapToResponse(Flight flight) {
        return new FlightResponse(
                flight.getIdentity().getValue(),
                flight.getFlightNumber().getValue(),
                flight.getFlightModel().getValue(),
                flight.getRouteId().getValue(),
                flight.getDepartureTime().getValue().toString(),
                flight.getArrivalTime().getValue().toString(),
                flight.getStatusFlight().getValue(),
                new FlightResponse.PricesInfo(
                        flight.getPrices() != null ? flight.getPrices().getStandardPrice() : 0.0,
                        flight.getPrices().getPassengerPrices().stream().map(price -> new FlightResponse.PricePassengerInfo(
                                price.getType(),
                                price.getPrice(),
                                price.getTax(),
                                price.getTotalPrice()
                        )).collect(Collectors.toList()),
                        flight.getPrices() != null ? flight.getPrices().getTax() : 0.0
                )
                ,
                flight.getSeats().stream().map(seat -> new FlightResponse.seat(
                        seat.getIdentity().getValue(),
                        seat.getSeatNumber().getValue(),
                        seat.getSeatClass().getValue(),
                        seat.getIsAvailable().getValue(),
                        seat.getPriceSeat().getValue()
                )).collect(Collectors.toList())
        );
    }

}
