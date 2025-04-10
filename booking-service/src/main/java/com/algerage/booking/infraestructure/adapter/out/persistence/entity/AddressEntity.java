package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ADDRESSES")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Builder
    public AddressEntity(
            final int addressId,
            final String street,
            final String postcode,
            final String city,
            final String country) {
        this.addressId = addressId;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
    }
}
