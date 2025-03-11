package com.airsofka.admin.application.admin.generateanalytics;

import com.airsofka.shared.application.Request;

public class GenerateAnalyticsRequest extends Request {
    private Double price;
    private Double taxes;
    private String state;
    private Double income;

    public GenerateAnalyticsRequest() {
        super(null);
    }

    public GenerateAnalyticsRequest(String aggregateId, Double price, Double taxes, String state, Double income) {
        super(aggregateId);
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
