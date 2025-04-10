package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class BlockedTimes {
    private Integer blockedTimeId;
    private Client client;
    private Service service;
    private String weekday;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
