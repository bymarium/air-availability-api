package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryAnalyticsPort;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AnalyticsAdapter implements IEventRepositoryAnalyticsPort {

    private final List<BookingEntity> bookings;

    public AnalyticsAdapter(List<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    @Override
    public GenerateAnalyticsResponse findAllBookings() {
        Map<String, Long> stateCounts = bookings.stream()
                .collect(Collectors.groupingBy(BookingEntity::getState, Collectors.counting()));

        int totalBookings = bookings.size();

        Map<String, Double> statePercentages = stateCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalBookings
                ));

        double totalIncome = bookings.stream()
                .mapToDouble(booking -> booking.getPayment() != null ? booking.getPayment().getTotal() : 0.0)
                .sum();

        double totalTaxes = totalIncome * 0.15;
        double incomeWithoutTaxes = totalIncome - totalTaxes;

        return new GenerateAnalyticsResponse(
                stateCounts,
                statePercentages,
                totalBookings,
                totalIncome,
                totalTaxes,
                incomeWithoutTaxes
        );
    }
}
