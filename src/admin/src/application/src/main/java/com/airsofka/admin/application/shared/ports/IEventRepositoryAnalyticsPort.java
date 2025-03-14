package com.airsofka.admin.application.shared.ports;

import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsResponse;
import reactor.core.publisher.Flux;
import java.util.List;

public interface IEventRepositoryAnalyticsPort {
    GenerateAnalyticsResponse findAllBookings();
}
