package com.algerage.booking.domain.model;

public record PaymentDetails(String clientId,
                             String name,
                             String surname,
                             String Street,
                             String zipCode,
                             String city,
                             String country) {

}
