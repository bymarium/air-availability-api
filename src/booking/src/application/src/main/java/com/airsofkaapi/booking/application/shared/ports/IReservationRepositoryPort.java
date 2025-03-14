package com.airsofkaapi.booking.application.shared.ports;

import com.airsofkaapi.booking.domain.reservation.Reservation;

public interface IReservationRepositoryPort {
  void saveReservation(Reservation reservation);
}
