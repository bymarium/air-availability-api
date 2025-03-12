package com.airsofka.admin.application.admin.issuebooking;

import com.airsofka.admin.application.shared.AdminMapper;
import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.admin.domain.admin.Admin;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.application.ICommandUseCase;
import reactor.core.publisher.Mono;

public class IssueBookingUseCase implements ICommandUseCase<IssueBookingRequest, Mono<AdminResponse>> {
    private final IEventRepositoryPort repository;
    private final IEventRepositoryBookingPort bookingRepository;

    public IssueBookingUseCase(IEventRepositoryPort repository, IEventRepositoryBookingPort bookingRepository) {
        this.repository = repository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Mono<AdminResponse> execute(IssueBookingRequest request) {
        return repository.findEventsByAggregateId(request.getAggregateId())
                .collectList()
                .map(events -> {
                    Admin admin = Admin.from(request.getAggregateId(), events);

                    admin.issueBooking(
                            request.getId(),
                            request.getBookingCode(),
                            request.getState()
                    );

                    Booking booking = new Booking();
//                    booking.setId(request.getId());
//                    booking.setBookingCode(request.getBookingCode());
                    booking.setState(State.of("ISSUED"));

                    bookingRepository.updateStatus(booking);
                    bookingRepository.saveBooking(booking);

                    admin.getUncommittedEvents().forEach(repository::save);
                    admin.markEventsAsCommitted();

                    return AdminMapper.mapToAdmin(admin);
                });
    }
}
