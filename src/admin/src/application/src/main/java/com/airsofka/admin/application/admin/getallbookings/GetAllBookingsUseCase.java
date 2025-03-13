package com.airsofka.admin.application.admin.getallbookings;

import com.airsofka.admin.application.shared.AdminMapper;
import com.airsofka.admin.application.shared.AdminResponse;
import com.airsofka.admin.application.shared.ports.IEventRepositoryPort;
import com.airsofka.admin.domain.admin.Admin;
import com.airsofka.shared.application.IQueryUseCase;
import com.airsofka.shared.domain.generic.DomainEvent;
import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.stream.Collectors;

public class GetAllBookingsUseCase  implements IQueryUseCase<Flux<AdminResponse>> {
    private final IEventRepositoryPort repository;

    public GetAllBookingsUseCase(IEventRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Flux<AdminResponse> execute() {
        return repository
                .findAllAggregates()
                .collectList()
                .map(events -> events.stream().collect(Collectors.groupingBy(DomainEvent::getAggregateRootId)))
                .map(aggregates -> aggregates.entrySet().stream().map(entry -> {
                    entry.getValue().sort(Comparator.comparing(DomainEvent::getWhen));
                    return Admin.from(entry.getKey(), entry.getValue());
                }).toList())
                .map(tables -> tables.stream().map(AdminMapper::mapToAdmin).toList())
                .flatMapMany(Flux::fromIterable);
    }
}
