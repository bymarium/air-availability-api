package com.airsofka.infra.sql.repositories;

import com.airsofka.infra.sql.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}
