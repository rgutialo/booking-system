package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.User;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User createModelFromEntity(UserEntity userEntity);

    UserEntity createEntityFromModel(User user);
}
