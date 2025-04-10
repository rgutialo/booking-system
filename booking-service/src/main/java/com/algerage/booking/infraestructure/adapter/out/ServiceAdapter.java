package com.algerage.booking.infraestructure.adapter.out;

import com.algerage.booking.application.port.out.ServicePort;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.domain.model.Service;
import com.algerage.booking.infraestructure.adapter.in.mappers.ClientMapper;
import com.algerage.booking.infraestructure.adapter.in.mappers.ServiceMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IServiceRepo;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@lombok.AllArgsConstructor
public class ServiceAdapter implements ServicePort {

    private final ServiceMapper serviceMapper;
    private final IServiceRepo serviceRepo;
    private final ClientMapper clientMapper;

    @Override
    public List<Service> getServicesPerClient(Client client) {
        ClientEntity clientEntity = clientMapper.createEntityFromModel(client);
        return serviceRepo.findByClient(clientEntity)
                .stream()
                .map(serviceMapper::createModelFromEntity)
                .toList();
    }

    @Override
    public Optional<Service> getServiceById(Long serviceId) {
        Optional<ServiceEntity> serviceEntity = serviceRepo.findById(serviceId);
        return serviceEntity.map(serviceMapper::createModelFromEntity);
    }
}
