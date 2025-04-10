package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Booking {
    private Integer bookingId;
    private User user;
    private Client client;
    private Service service;
    private LocalDateTime bookingStart;
    private LocalDateTime bookingEnd;
    private BookingStatus bookingStatus;
}