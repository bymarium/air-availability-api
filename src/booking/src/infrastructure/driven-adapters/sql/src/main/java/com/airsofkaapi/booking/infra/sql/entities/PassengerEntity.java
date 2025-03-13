package com.airsofkaapi.booking.infra.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PASSENGER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassengerEntity {
  @Id
  private String id;
  private String type;
  private String firstName;
  private String lastName;
  private String documentType;
  private String documentNumber;
  private String gender;
  private LocalDate birthdayDate;
  private String email;
  private String phone;
  private String originSeat;
  private String destinationSeat;

  @ManyToOne
  @JoinColumn(name = "reservation_id")
  private ReservationEntity reservation;
}
