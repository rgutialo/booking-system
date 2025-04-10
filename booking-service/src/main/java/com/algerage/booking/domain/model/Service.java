package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Service {

    private Integer serviceId;
    private Client client;
    private String name;
    private Integer duration;
    private Double price;
}
