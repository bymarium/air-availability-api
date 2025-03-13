package com.airsofka.admin.infra.mysql.repositories;

import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingJpaRepository extends JpaRepository<BookingEntity, String> {
}
