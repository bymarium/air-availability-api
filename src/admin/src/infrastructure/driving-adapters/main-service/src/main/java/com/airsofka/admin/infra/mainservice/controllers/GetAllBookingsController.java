package com.airsofka.admin.infra.mainservice.controllers;

import com.airsofka.admin.application.admin.getallbookings.BookingConfirmedResponse;
import com.airsofka.admin.application.admin.getallbookings.GetAllBookingsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class GetAllBookingsController {
    private final GetAllBookingsUseCase useCase;

    public GetAllBookingsController(GetAllBookingsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping
     public List<BookingConfirmedResponse> getAllBookings() {
        return useCase.execute();
    }
}
