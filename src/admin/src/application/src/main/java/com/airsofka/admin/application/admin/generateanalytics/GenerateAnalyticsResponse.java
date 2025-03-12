package com.airsofka.admin.application.admin.generateanalytics;

import java.util.Map;

public class GenerateAnalyticsResponse {
    private Map<String, Long> stateCounts;
    private Map<String, Double> statePercentages;
    private int totalBookings;
    private double totalIncome;
    private double totalTaxes;
    private double incomeWithoutTaxes;

    public GenerateAnalyticsResponse() {
    }

    public GenerateAnalyticsResponse(Map<String, Long> stateCounts, Map<String, Double> statePercentages, int totalBookings, double totalIncome, double totalTaxes, double incomeWithoutTaxes) {
        this.stateCounts = stateCounts;
        this.statePercentages = statePercentages;
        this.totalBookings = totalBookings;
        this.totalIncome = totalIncome;
        this.totalTaxes = totalTaxes;
        this.incomeWithoutTaxes = incomeWithoutTaxes;
    }

    public Map<String, Long> getStateCounts() {
        return stateCounts;
    }

    public void setStateCounts(Map<String, Long> stateCounts) {
        this.stateCounts = stateCounts;
    }

    public Map<String, Double> getStatePercentages() {
        return statePercentages;
    }

    public void setStatePercentages(Map<String, Double> statePercentages) {
        this.statePercentages = statePercentages;
    }

    public int getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(int totalBookings) {
        this.totalBookings = totalBookings;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double getIncomeWithoutTaxes() {
        return incomeWithoutTaxes;
    }

    public void setIncomeWithoutTaxes(double incomeWithoutTaxes) {
        this.incomeWithoutTaxes = incomeWithoutTaxes;
    }
}
