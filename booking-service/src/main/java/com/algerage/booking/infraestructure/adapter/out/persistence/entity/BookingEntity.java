package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOOKING")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private ClientEntity client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    @Column(name = "booking_start", nullable = false)
    private LocalDateTime bookingStart;

    @Column(name = "booking_end", nullable = false)
    private LocalDateTime bookingEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_status", nullable = false)
    private BookingStatusEntity bookingStatus;

    @Builder
    public BookingEntity(
            final Integer bookingId,
            final UserEntity user,
            final ClientEntity client,
            final ServiceEntity service,
            final LocalDateTime bookingStart,
            final LocalDateTime bookingEnd,
            final BookingStatusEntity bookingStatus) {
        this.bookingId = bookingId;
        this.user = user;
        this.client = client;
        this.service = service;
        this.bookingStart = bookingStart;
        this.bookingEnd = bookingEnd;
        this.bookingStatus = bookingStatus;
    }
}
