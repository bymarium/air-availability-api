package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.admin.domain.admin.Admin;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.State;

import com.airsofka.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CancelBookingUseCaseTest {

    @Mock
    private IEventRepositoryPort eventRepository;

    @Mock
    private IEventRepositoryBookingPort bookingRepository;

    @InjectMocks
    private CancelBookingUseCase cancelBookingUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCancelBookingSuccessfully() {
        String aggregateId = UUID.randomUUID().toString();
        CancelBookingRequest request = new CancelBookingRequest(aggregateId, aggregateId, "32DERJ2222", "PENDING");

        List<DomainEvent> previousEvents = List.of();
        when(eventRepository.findEventsByAggregateId(aggregateId))
                .thenReturn(Flux.fromIterable(previousEvents));

        ArgumentCaptor<Booking> bookingCaptor = ArgumentCaptor.forClass(Booking.class);
        doNothing().when(bookingRepository).updateStatus(any(Booking.class));

        Mono<AdminResponse> result = cancelBookingUseCase.execute(request);

        result.subscribe(response -> {
            assertNotNull(response);
            assertEquals(aggregateId, response.getAdminId());
        });

        verify(bookingRepository).updateStatus(bookingCaptor.capture());
        Booking updatedBooking = bookingCaptor.getValue();
        assertNotNull(updatedBooking);
        assertEquals(State.of("CANCELED"), updatedBooking.getState());

        verify(bookingRepository).saveBooking(any(Booking.class));

        verify(eventRepository, times(1)).save(any(DomainEvent.class));
    }
}
