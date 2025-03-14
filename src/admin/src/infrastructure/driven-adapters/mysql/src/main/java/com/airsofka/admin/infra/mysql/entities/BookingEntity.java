package com.airsofka.admin.infra.mysql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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
    @Column(name = "id", nullable = false)
    private String id;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private LocalDate arrivalDate;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false, unique = true)
    private String reservationCode;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column(nullable = false)
    private String originFlightId;

    @Column(nullable = false)
    private String destinationFlightId;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PassengerEntity> passengers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentEntity payment;

}
