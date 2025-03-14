package com.airsofkaapi.booking.domain.shared.dtos;

public class PaymentDto {
  private String paymentMethod;
  private Double subtotal;
  private Double total;
  private Double discount;
  private CardDto card;
  private PseDto pse;
  private BillingAddressDto billingAddress;

  public String getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public CardDto getCard() {
    return card;
  }

  public void setCard(CardDto card) {
    this.card = card;
  }

  public PseDto getPse() {
    return pse;
  }

  public void setPse(PseDto pse) {
    this.pse = pse;
  }

  public BillingAddressDto getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(BillingAddressDto billingAddress) {
    this.billingAddress = billingAddress;
  }
}
