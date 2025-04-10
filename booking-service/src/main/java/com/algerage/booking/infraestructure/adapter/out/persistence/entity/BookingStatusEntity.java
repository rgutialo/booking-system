package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BOOKING_STATUS")
public class BookingStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingStatusId;

    @Column(name = "status")
    private String status;

    @Builder
    public BookingStatusEntity(
            final int bookingStatusId,
            final String status) {
        this.bookingStatusId = bookingStatusId;
        this.status = status;
    }
}
