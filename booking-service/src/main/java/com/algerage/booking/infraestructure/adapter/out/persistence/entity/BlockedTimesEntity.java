package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BLOCKED_TIMES")
public class BlockedTimesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blockedTimeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientId", nullable = false)
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serviceId", nullable = false)
    private ServiceEntity service;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "weekday", nullable = false)
    private String weekday;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endDateTime;

    @Builder
    public BlockedTimesEntity(
            final Integer blockedTimeId,
            final ClientEntity client,
            final ServiceEntity service,
            final String weekday,
            final LocalDateTime startDateTime,
            final LocalDateTime endDateTime) {
        this.blockedTimeId = blockedTimeId;
        this.client = client;
        this.service = service;
        this.weekday = weekday;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
