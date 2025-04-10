package com.algerage.booking.infraestructure.adapter.in;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Builder
public class AvailabilityBookingRequest {
    private Long clientId;
    private Long serviceId;
    private LocalDate date;
}
