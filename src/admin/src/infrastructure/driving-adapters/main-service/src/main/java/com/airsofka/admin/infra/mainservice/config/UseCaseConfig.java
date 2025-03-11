package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import com.airsofka.admin.application.admin.confirmbooking.ConfirmBookingUseCase;
import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsUseCase;
import com.airsofka.admin.application.admin.getallbookings.GetAllBookingsUseCase;
import com.airsofka.admin.application.admin.issuebooking.IssueBookingUseCase;
import com.airsofka.admin.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CancelBookingUseCase cancelBookingUseCase(MongoAdapter adapter) {
        return new CancelBookingUseCase(adapter);
    }

    @Bean
    public ConfirmBookingUseCase confirmBookingUseCase(MongoAdapter adapter) {
        return new ConfirmBookingUseCase(adapter);
    }

    @Bean
    public GenerateAnalyticsUseCase generateAnalyticsUseCase(MongoAdapter adapter) {
        return new GenerateAnalyticsUseCase(adapter);
    }

    @Bean
    public IssueBookingUseCase issueBookingUseCase(MongoAdapter adapter) {
        return new IssueBookingUseCase(adapter);
    }

    @Bean
    public GetAllBookingsUseCase getAllBookingsUseCase(MongoAdapter adapter) {
        return new GetAllBookingsUseCase(adapter);
    }

}
