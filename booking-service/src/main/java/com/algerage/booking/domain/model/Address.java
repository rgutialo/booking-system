package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {

    private int addressId;
    private String street;
    private String postcode;
    private String city;
    private String country;
}
