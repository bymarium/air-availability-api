package com.airsofka.admin.infra.mysql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class BookingEntity {

    @Id
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @Column(nullable = false)
    private LocalDateTime arrivalDate;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false, unique = true)
    private String reservationCode;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "origin_flight_id", referencedColumnName = "id")
    private FlightEntity originFlight;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "destination_flight_id", referencedColumnName = "id")
    private FlightEntity destinationFlight;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PassengerEntity> passengers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

}
