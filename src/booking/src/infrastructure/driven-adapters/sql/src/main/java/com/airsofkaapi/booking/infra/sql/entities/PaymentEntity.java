package com.airsofkaapi.booking.infra.sql.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentEntity {
  @Id
  private String id;
  private String paymentMethod;
  private Double subtotal;
  private Double total;
  private Double discount;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "card_id")
  private CardEntity card;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "pse_id")
  private PseEntity pse;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "billing_address_id")
  private BillingAddressEntity billingAddress;
}
