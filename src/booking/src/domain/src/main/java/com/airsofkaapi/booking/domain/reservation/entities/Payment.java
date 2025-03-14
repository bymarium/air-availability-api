package com.airsofkaapi.booking.domain.reservation.entities;

import com.airsofka.shared.domain.generic.Entity;
import com.airsofkaapi.booking.domain.reservation.values.BillingAddress;
import com.airsofkaapi.booking.domain.reservation.values.Card;
import com.airsofkaapi.booking.domain.reservation.values.Money;
import com.airsofkaapi.booking.domain.reservation.values.PaymentId;
import com.airsofkaapi.booking.domain.reservation.values.PaymentMethod;
import com.airsofkaapi.booking.domain.reservation.values.Pse;

public class Payment extends Entity<PaymentId> {
  private Money subtotal;
  private Money discount;
  private Money total;
  private PaymentMethod paymentMethod;
  private Card card;
  private Pse pse;
  private BillingAddress billingAddress;

  public Payment(PaymentId identity, Money subtotal, Money discount, Money total, PaymentMethod paymentMethod, Card card, Pse pse, BillingAddress billingAddress) {
    super(identity);
    this.subtotal = subtotal;
    this.discount = discount;
    this.total = total;
    this.paymentMethod = paymentMethod;
    this.card = card;
    this.pse = pse;
    this.billingAddress = billingAddress;
  }

  public Payment(Money subtotal, Money discount, Money total, PaymentMethod paymentMethod, Card card, Pse pse, BillingAddress billingAddress) {
    super(new PaymentId());
    this.subtotal = subtotal;
    this.discount = discount;
    this.total = total;
    this.paymentMethod = paymentMethod;
    this.card = card;
    this.pse = pse;
    this.billingAddress = billingAddress;
  }
  // region Getters and Setters

  public Money getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Money subtotal) {
    this.subtotal = subtotal;
  }

  public Money getDiscount() {
    return discount;
  }

  public void setDiscount(Money discount) {
    this.discount = discount;
  }

  public Money getTotal() {
    return total;
  }

  public void setTotal(Money total) {
    this.total = total;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public Pse getPse() {
    return pse;
  }

  public void setPse(Pse pse) {
    this.pse = pse;
  }

  public BillingAddress getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(BillingAddress billingAddress) {
    this.billingAddress = billingAddress;
  }
  //endregion
}
