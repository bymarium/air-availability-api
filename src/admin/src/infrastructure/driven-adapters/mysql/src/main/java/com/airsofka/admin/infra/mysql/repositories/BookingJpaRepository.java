package com.airsofka.admin.infra.mysql.repositories;

import com.airsofka.admin.domain.admin.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpaRepository extends JpaRepository<Booking, String> {
}
