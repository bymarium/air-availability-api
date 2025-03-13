package com.airsofkaapi.booking.infra.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BILLING_ADDRESS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BillingAddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String addressOne;
  private String addressTwo;
  private String country;
  private String city;
  private String state;
  private Integer postalCode;
  private String phoneNumber;
  private String email;
}
