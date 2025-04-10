package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.BlockedTimes;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BlockedTimesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlockedTimesMapper {
    BlockedTimes createModelFromEntity(final BlockedTimesEntity blockedTimesEntity);

    BlockedTimesEntity createEntityFromModel(final BlockedTimes blockedTimes);
}
