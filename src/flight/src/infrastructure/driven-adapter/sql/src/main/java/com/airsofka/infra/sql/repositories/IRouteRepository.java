package com.airsofka.infra.sql.repositories;

import com.airsofka.infra.sql.entities.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends JpaRepository<RouteEntity, Long> {
}