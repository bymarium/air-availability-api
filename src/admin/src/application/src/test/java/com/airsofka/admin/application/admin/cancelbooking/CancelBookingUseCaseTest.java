package com.airsofka.admin.application.admin.cancelbooking;

import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryBookingPort;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.admin.domain.admin.entities.Booking;
import com.airsofka.admin.domain.admin.values.State;
import com.airsofka.shared.domain.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

    class CancelBookingUseCaseTest {

        @Mock
        private IEventRepositoryPort repository;

        @Mock
        private IEventRepositoryBookingPort bookingRepository;

        @InjectMocks
        private CancelBookingUseCase cancelBookingUseCase;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
        }

        @Test
        void execute_ShouldCancelBookingAndSaveChanges() {
            // Arrange
            String aggregateId = "admin-123";
            String bookingId = "2549ea17-3b9e-4df1-ba0b-bddae953b733";
            String bookingCode = "32DERJ2222";
            String previousState = "PENDING";

            CancelBookingRequest request = new CancelBookingRequest(aggregateId, bookingId, bookingCode, previousState);

            List<DomainEvent> events = Collections.emptyList(); // Simulación de eventos previos
            when(repository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.fromIterable(events));

            // Simulación de guardar eventos y cambios en la reserva
            doNothing().when(repository).save(any(DomainEvent.class));
            doNothing().when(bookingRepository).updateStatus(any(Booking.class));
            doNothing().when(bookingRepository).saveBooking(any(Booking.class));


            // Act
            Mono<AdminResponse> resultMono = cancelBookingUseCase.execute(request);

            // Assert
            AdminResponse response = resultMono.block();
            assertNotNull(response);
            assertEquals(aggregateId, response.getAdminId());

            // Verificar interacciones
            verify(repository).findEventsByAggregateId(aggregateId);
            verify(bookingRepository).updateStatus(argThat(booking -> booking.getState().equals(State.of("CANCELED"))));
            verify(bookingRepository).saveBooking(argThat(booking -> booking.getState().equals(State.of("CANCELED"))));
            verify(repository, atLeastOnce()).save(any(DomainEvent.class));
        }

        @Test
        void execute_ShouldHandleEmptyEvents() {
            // Arrange
            String aggregateId = "admin-123";
            String bookingId = "2549ea17-3b9e-4df1-ba0b-bddae953b733";
            String bookingCode = "32DERJ2222";
            String previousState = "PENDING";

            CancelBookingRequest request = new CancelBookingRequest(aggregateId, bookingId, bookingCode, previousState);

            when(repository.findEventsByAggregateId(aggregateId)).thenReturn(Flux.empty());

            doNothing().when(repository).save(any(DomainEvent.class));
            doNothing().when(bookingRepository).updateStatus(any(Booking.class));
            doNothing().when(bookingRepository).saveBooking(any(Booking.class));

            // Act
            Mono<AdminResponse> resultMono = cancelBookingUseCase.execute(request);

            // Assert
            AdminResponse response = resultMono.block();
            assertNotNull(response);
            assertEquals(aggregateId, response.getAdminId());

            // Verificar interacciones
            verify(repository).findEventsByAggregateId(aggregateId);
            verify(bookingRepository).updateStatus(argThat(booking -> booking.getState().equals(State.of("CANCELED"))));
            verify(bookingRepository).saveBooking(argThat(booking -> booking.getState().equals(State.of("CANCELED"))));
            verify(repository, atLeastOnce()).save(any(DomainEvent.class));
        }
    }