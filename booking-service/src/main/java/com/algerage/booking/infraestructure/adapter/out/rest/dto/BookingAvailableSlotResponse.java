package com.algerage.booking.infraestructure.adapter.out.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BookingAvailableSlotResponse {
    private String serviceId;
    private String date;
    private String startTime;
    private String endTime;
    private Double price;
}
