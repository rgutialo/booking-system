package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "BUSINESS_HOURS")
public class BusinessHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessHoursId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serviceId", nullable = false)
    private ServiceEntity service;

    @Column(name = "weekday", nullable = false)
    private String weekday;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;


    @Builder
    public BusinessHoursEntity(
            final Long businessHoursId,
            final ServiceEntity service,
            final String weekday,
            final LocalTime startTime,
            final LocalTime endTime) {
        this.businessHoursId = businessHoursId;
        this.service = service;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
