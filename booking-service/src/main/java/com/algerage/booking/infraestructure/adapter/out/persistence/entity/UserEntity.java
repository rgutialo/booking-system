package com.algerage.booking.infraestructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/** USER entity */
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(name = "USERS_ADDRESSES", joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    Set<AddressEntity> addresses = new HashSet<>();

    @Builder
    public UserEntity(
            final int userId,
            final String name,
            final String login,
            final String lastName,
            final String surname,
            final String email,
            final String telephone) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.lastName = lastName;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
    }
}
