package com.airsofka.admin.application.shared.ports;

import com.airsofka.admin.application.admin.getallbookings.BookingConfirmedResponse;
import java.util.List;

public interface IEventConfirmedPort {
    List<BookingConfirmedResponse> findAllBookingsConfirmed();
}
