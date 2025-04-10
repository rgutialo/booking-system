package com.algerage.booking.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class User {

    private int userId;
    private String name;
    private String login;
    private String lastName;
    private String surname;
    private String email;
    private String telephone;
    private Set<Address> addresses;
}
