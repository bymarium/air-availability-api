package com.airsofka.infra.sql.adapters;

import com.airsofka.flight.application.shared.flight.FlightListResponse;
import com.airsofka.flight.application.shared.flight.FlightResponse;
import com.airsofka.flight.application.shared.flight.SeatResponse;
import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;


import com.airsofka.infra.sql.entities.FlightEntity;
import com.airsofka.infra.sql.entities.PriceEntity;
import com.airsofka.infra.sql.entities.SeatEntity;
import com.airsofka.infra.sql.repositories.FlightRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MySQLAdapter implements IFlightRepositoryPort {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightAdapter flightAdapter;

    public MySQLAdapter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void saveFlight(Flight flight) {
        FlightEntity flightEntity = FlightAdapter.toEntity(flight);
        flightRepository.save(flightEntity);
    }

    @Override
    @Transactional
    public void updateFlight(Flight flight) {
        FlightEntity flightFound = flightRepository.findById(flight.getIdentity().getValue()).orElseThrow(() -> new RuntimeException("Flight not found"));
        flightFound.setFlightNumber(flight.getFlightNumber().getValue());
        flightFound.setDepartureTime(Date.from(flight.getDepartureTime().getValue().toInstant()));
        flightFound.setArrivalTime(Date.from(flight.getArrivalTime().getValue().toInstant()));
        flightFound.setStatus(flight.getStatusFlight().getValue());
        flightFound.setRouteId(flight.getRouteId().getValue());

        PriceEntity price = flightFound.getPrice();

        if (price == null) {
            throw new RuntimeException("Price information not found for this flight.");
        }
        price.setPriceStandard(flight.getPrices().getStandardPrice());
        price.setTax(flight.getPrices().getTax());
        flightFound.getPrice().getPassengerPrices().forEach(passengerPrice -> {

            passengerPrice.setBasePrice(flight.getPrices().getPassengerPrices().stream().filter(pp -> pp.getType().equals(passengerPrice.getType())).findFirst().get().getPrice());
            passengerPrice.setTax(flight.getPrices().getPassengerPrices().stream().filter(pp -> pp.getType().equals(passengerPrice.getType())).findFirst().get().getTax());
            passengerPrice.setTotalPrice(flight.getPrices().getPassengerPrices().stream().filter(pp -> pp.getType().equals(passengerPrice.getType())).findFirst().get().getTotalPrice());
        });

        flightRepository.save(flightFound);
    }

    @Override
    public List<FlightListResponse> findAll() {
        return flightRepository.findAll().stream().map(FlightAdapter::toResponse).collect(Collectors.toList());
    }

    @Override
    public List<FlightResponse> findAllReseponse() {
        return flightRepository.findAll().stream().map(FlightAdapter::toResponseFlight).collect(Collectors.toList());
    }

    @Override
    public FlightListResponse findById(String aggregateId) {
        FlightEntity flight = flightRepository.findById(aggregateId).orElseThrow(() -> new RuntimeException("Flight not found"));
        return FlightAdapter.toResponse(flight);
    }

    @Override
    public void updateStatus(Flight flight) {
        FlightEntity flightFound = flightRepository.findById(flight.getIdentity().getValue()).orElseThrow(() -> new RuntimeException("Flight not found"));
        flightFound.setStatus(flight.getStatusFlight().getValue());
        flightRepository.save(flightFound);
    }

    @Override
    public void changeRoute(Flight flight) {
        FlightEntity flightFound = flightRepository.findById(flight.getIdentity().getValue()).orElseThrow(() -> new RuntimeException("Flight not found"));
        flightFound.setRouteId(flight.getRouteId().getValue());
        flightRepository.save(flightFound);
    }

    @Override
    @Transactional
    public void changeSeat(String aggregateId, String seatNumber) {
        FlightEntity flightFound = flightRepository.findByIdWithSeats(aggregateId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        SeatEntity seat = flightFound.getSeats().stream()
                .filter(s -> s.getSeatNumber().equals(seatNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Seat not found in this flight"));

        seat.setIsAvailable(false);
        flightRepository.save(flightFound);
    }

    @Override
    @Transactional
    public void enableSeat(String aggregateId, String seatNumber) {
        FlightEntity flightFound = flightRepository.findByIdWithSeats(aggregateId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        SeatEntity seat = flightFound.getSeats().stream()
                .filter(s -> s.getSeatNumber().equals(seatNumber))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Seat not found in this flight"));

        seat.setIsAvailable(true);
        flightRepository.save(flightFound);
    }

    @Override
    @Transactional
    public void removeFlight(String aggregateId) {
        flightRepository.deleteById(aggregateId);
    }


    @Override
    public SeatResponse findSeatsById(String aggregateId) {
        System.out.println(aggregateId);
        FlightEntity flight = flightRepository.findById(aggregateId).orElseThrow(() -> new RuntimeException("Flight not found"));
        return FlightAdapter.toSeatResponse(flight);
    }


}
