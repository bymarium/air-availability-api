package com.airsofka.infra.sql.repositories;


import com.airsofka.infra.sql.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
}
