package com.airsofkaapi.booking.infra.sql.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationEntity {
  @Id
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
  @Column(unique = true)
  private String reservationCode;
  @Column(nullable = false)
  private LocalDate creationDate;
  @Column(nullable = false)
  private String originFlightId;
  @Column(nullable = false)
  private String destinationFlightId;
  @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
  private List<PassengerEntity> passengers;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "payment_id")
  private PaymentEntity payment;
}
