package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BookingAvailableSlot {
    private Service service;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
