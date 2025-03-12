package com.airsofka.admin.infra.mainservice.config;

import com.airsofka.admin.application.admin.cancelbooking.CancelBookingUseCase;
import com.airsofka.admin.application.admin.confirmbooking.ConfirmBookingUseCase;
import com.airsofka.admin.application.admin.generateanalytics.GenerateAnalyticsUseCase;
import com.airsofka.admin.application.admin.getallbookings.GetAllBookingsUseCase;
import com.airsofka.admin.application.admin.issuebooking.IssueBookingUseCase;
import com.airsofka.admin.infra.mongo.adapters.MongoAdapter;
import com.airsofka.admin.infra.mysql.adapters.MysqlAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CancelBookingUseCase cancelBookingUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter) {
        return new CancelBookingUseCase(adapter, mysqlAdapter);
    }

    @Bean
    public ConfirmBookingUseCase confirmBookingUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter) {
        return new ConfirmBookingUseCase(adapter);
    }

    @Bean
    public GenerateAnalyticsUseCase generateAnalyticsUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter) {
        return new GenerateAnalyticsUseCase(adapter);
    }

    @Bean
    public IssueBookingUseCase issueBookingUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter) {
        return new IssueBookingUseCase(adapter, mysqlAdapter);
    }

    @Bean
    public GetAllBookingsUseCase getAllBookingsUseCase(MongoAdapter adapter, MysqlAdapter mysqlAdapter) {
        return new GetAllBookingsUseCase(adapter);
    }

}
