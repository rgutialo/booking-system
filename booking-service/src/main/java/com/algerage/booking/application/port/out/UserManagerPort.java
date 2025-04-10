package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.User;

import java.util.Optional;

public interface UserManagerPort {

    Optional<User> getUserById(final long userId);
    Optional<User> getUserByLogin(final String login);
    Optional<User> getUserByEmail(final String email);
}
