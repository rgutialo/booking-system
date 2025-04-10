package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.Client;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client createModelFromEntity(final ClientEntity clientEntity);
    ClientEntity createEntityFromModel(final Client client);
}
