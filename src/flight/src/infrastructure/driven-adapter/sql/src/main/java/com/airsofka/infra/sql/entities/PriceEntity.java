package com.airsofka.infra.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "flight_id")  // O cualquier otro nombre de columna
    private FlightEntity flight;

    public PriceEntity(Double price) {
        this.priceStandard = price;
        this.childPrice = price * 0.75;
        this.infantPrice = price * 0.45;
    }
}
