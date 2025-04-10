package com.algerage.booking.infraestructure.adapter.in.mappers;


import com.algerage.booking.domain.model.Service;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    Service createModelFromEntity(final ServiceEntity serviceEntity);

    ServiceEntity createEntityFromModel(final Service service);
}
