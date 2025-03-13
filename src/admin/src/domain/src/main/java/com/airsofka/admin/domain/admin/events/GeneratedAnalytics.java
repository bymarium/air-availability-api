package com.airsofka.admin.domain.admin.events;

import com.airsofka.shared.domain.generic.DomainEvent;

public class GeneratedAnalytics extends DomainEvent {
    private Double price;
    private Double taxes;
    private String state;
    private Double income;

    public GeneratedAnalytics() {
        super(EventsEnum.GENERATED_ANALYTICS.name());
    }

    public GeneratedAnalytics(Double price, Double taxes, String state, Double income) {
        super(EventsEnum.GENERATED_ANALYTICS.name());
        this.price = price;
        this.taxes = taxes;
        this.state = state;
        this.income = income;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
