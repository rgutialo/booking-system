package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Booking {
    String clientId;
    String date;
    String time;
    String details;
}
