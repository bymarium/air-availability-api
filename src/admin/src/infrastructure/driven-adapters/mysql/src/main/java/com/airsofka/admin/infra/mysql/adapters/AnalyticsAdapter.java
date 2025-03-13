package com.airsofka.admin.infra.mysql.adapters;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryAnalyticsPort;
import com.airsofka.admin.infra.mysql.entities.BookingEntity;
import com.airsofka.admin.infra.mysql.repositories.BookingJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyticsAdapter implements IEventRepositoryAnalyticsPort {
    private final BookingJpaRepository bookingJpaRepository;

    @Autowired
    public AnalyticsAdapter(BookingJpaRepository bookingJpaRepository) {
        this.bookingJpaRepository = bookingJpaRepository;
    }

    @Override
    public GenerateAnalyticsResponse findAllBookings() {
        List<BookingEntity> bookings = bookingJpaRepository.findAll();
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
