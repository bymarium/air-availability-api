package com.airsofka.infra.mongo.repositories;

import com.airsofka.infra.mongo.entities.PriceEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}
