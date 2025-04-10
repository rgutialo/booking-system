package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@Builder
public class BusinessHours {

    private Integer businessHoursId;
    private Service service;
    private String weekday;
    private LocalTime startTime;
    private LocalTime endTime;
}
