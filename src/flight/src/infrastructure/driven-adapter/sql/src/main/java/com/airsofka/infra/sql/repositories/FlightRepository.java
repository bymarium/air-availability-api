package com.airsofka.infra.sql.repositories;


import com.airsofka.infra.sql.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, String> {
    @Query("SELECT f FROM FlightEntity f JOIN FETCH f.seats WHERE f.id = :id")
    Optional<FlightEntity> findByIdWithSeats(@Param("id") String id);
}
