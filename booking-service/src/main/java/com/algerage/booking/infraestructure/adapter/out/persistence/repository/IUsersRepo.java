package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUsersRepo extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByEmail(String email);
}
