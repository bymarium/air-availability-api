package com.airsofkaapi.booking.infra.sql.repositories;

import com.airsofkaapi.booking.infra.sql.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservationRepository extends JpaRepository<ReservationEntity, String> {
}
