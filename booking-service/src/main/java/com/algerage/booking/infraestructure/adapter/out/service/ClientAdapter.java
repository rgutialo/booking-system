package com.algerage.booking.infraestructure.adapter.out.service;

import com.algerage.booking.application.port.out.ClientPort;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.infraestructure.adapter.in.mappers.ClientMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IClientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientAdapter implements ClientPort {

    private final IClientRepo clientRepo;
    private final ClientMapper clientMapper;


    @Override
    public Optional<Client> obtainClient(Long clientId) {
        return clientRepo.findById(clientId).map(clientMapper::createModelFromEntity);
    }
}
