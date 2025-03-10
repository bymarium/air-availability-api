package com.airsofka.infra.mongo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "price")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double priceStandard;
    private Double childPrice;
    private Double infantPrice;

    public PriceEntity(Double price) {
        this.priceStandard = price;
        this.childPrice = price * 0.75;
        this.infantPrice = price * 0.45;
    }
}
