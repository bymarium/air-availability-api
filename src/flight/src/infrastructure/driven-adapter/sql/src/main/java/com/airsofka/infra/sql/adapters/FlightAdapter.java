package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.flight.domain.flight.entities.Seat;
import com.airsofka.flight.domain.flight.values.IsAvailable;
import com.airsofka.flight.domain.flight.values.PriceSeat;
import com.airsofka.flight.domain.flight.values.SeatClass;
import com.airsofka.flight.domain.flight.values.SeatNumber;
import com.airsofka.flight.domain.flight.values.StatusFlight;
import com.airsofka.infra.sql.entities.FlightEntity;
import com.airsofka.infra.sql.entities.PassengerPriceEntity;
import com.airsofka.infra.sql.entities.PriceEntity;
import com.airsofka.infra.sql.entities.SeatEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightAdapter {
    public static FlightEntity toEntity(Flight flight) {
        FlightEntity entity = new FlightEntity();
        entity.setId(flight.getIdentity().getValue());
        entity.setFlightNumber(flight.getFlightNumber().getValue());
        entity.setDepartureTime(flight.getDepartureTime().getValue());
        entity.setArrivalTime(flight.getArrivalTime().getValue());
        entity.setRouteId(flight.getRouteId().getValue());
        entity.setStatus(flight.getStatusFlight().getValue());
        entity.setFlightModel(flight.getFlightModel().getValue());

        PriceEntity price = new PriceEntity();
        price.setPriceStandard(flight.getPrices().getStandardPrice());
        price.setTax(flight.getPrices().getTax());

        List<PassengerPriceEntity> passengerPrices = flight.getPrices().getPassengerPrices()
                .stream()
                .map(pp -> new PassengerPriceEntity(
                        null,
                        pp.getType(),
                        pp.getPrice(),
                        pp.getTax(),
                        pp.getTotalPrice(),
                        price
                ))
                .collect(Collectors.toList());
        price.setPassengerPrices(passengerPrices);
        price.setFlight(entity);
        entity.setPrice(price);


        List<SeatEntity> seatEntities = flight.getSeats().stream().map(
                seat -> {
                    SeatEntity seatEntity = new SeatEntity();
                    seatEntity.setSeatNumber(seat.getSeatNumber().getValue());
                    seatEntity.setSeatClass(seat.getSeatClass().getValue());
                    seatEntity.setIsAvailable(seat.getIsAvailable().getValue());
                    seatEntity.setPriceSeat(seat.getPriceSeat().getValue());
                    seatEntity.setFlight(entity);
                    return seatEntity;
                }
        ).collect(Collectors.toList());
        entity.setSeats(seatEntities);
        entity.setSeatsCount(entity.getSeats().size());
        return entity;
    }

    public static Flight toDomain(FlightEntity entity) {
        Flight flight = new Flight(
                entity.getFlightNumber(),
                entity.getRouteId(),
                entity.getPrice().getPriceStandard(),
                entity.getDepartureTime(),
                entity.getArrivalTime(),
                entity.getFlightModel()
        );
        flight.setStatusFlight(StatusFlight.of(entity.getStatus()));
        List<Seat> seats = entity.getSeats().stream().map(
                seat -> {
                    return new Seat(
//                            SeatId.of(seat.getSeatId()),
                            SeatNumber.of(seat.getSeatNumber()),
                            SeatClass.of(seat.getSeatClass()),
                            IsAvailable.of(seat.getIsAvailable()),
                            PriceSeat.of(seat.getPriceSeat())
                    );
                }).collect(Collectors.toList());
        flight.setSeats(seats);

        return flight;
    }

    public static FlightListResponse toResponse(FlightEntity entity) {
        return new FlightListResponse(
                entity.getId(),
                entity.getFlightNumber(),
                entity.getFlightModel(),
                entity.getRouteId(),
                entity.getDepartureTime(),
                entity.getArrivalTime(),
                entity.getStatus(),
                entity.getPrice().getPriceStandard(),
                entity.getSeats().size(),
                entity.getPrice().getTax()
        );
    }
}
