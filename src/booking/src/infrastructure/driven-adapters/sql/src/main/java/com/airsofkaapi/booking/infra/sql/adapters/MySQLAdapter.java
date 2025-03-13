package com.airsofkaapi.booking.infra.sql.adapters;

import com.airsofkaapi.booking.application.shared.ports.IReservationRepositoryPort;
import com.airsofkaapi.booking.domain.reservation.Reservation;
import com.airsofkaapi.booking.infra.sql.entities.ReservationEntity;
import com.airsofkaapi.booking.infra.sql.repositories.IReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class MySQLAdapter implements IReservationRepositoryPort {
  private final IReservationRepository reservationRepository;

  public MySQLAdapter(IReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void saveReservation(Reservation reservation) {
    ReservationEntity reservationEntity = ReservationAdapter.toEntity(reservation);
    reservationRepository.save(reservationEntity);
  }
}
