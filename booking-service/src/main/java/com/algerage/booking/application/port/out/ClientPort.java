package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.Client;

import java.util.Optional;

public interface ClientPort {

    Optional<Client> obtainClient(Long clientId);
}
