package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.BusinessHours;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BusinessHoursEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessHoursMapper {
    BusinessHours createModelFromEntity(final BusinessHoursEntity businessHoursEntity);

    BusinessHoursEntity createEntityFromModel(final BusinessHours businessHours);

}
