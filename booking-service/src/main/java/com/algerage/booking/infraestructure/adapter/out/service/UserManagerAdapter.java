package com.algerage.booking.infraestructure.adapter.out.service;

import com.algerage.booking.application.port.out.UserManagerPort;
import com.algerage.booking.domain.model.User;
import com.algerage.booking.infraestructure.adapter.in.mappers.UserMapper;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.UserEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.repository.IUsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManagerAdapter implements UserManagerPort {

    private final IUsersRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public Optional<User> getUserById(long userId) {
        Optional<UserEntity> userEntity = userRepo.findById(userId);
        return userEntity.map(userMapper::createModelFromEntity);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        Optional<UserEntity> userEntity = userRepo.findByLogin(login);
        return userEntity.map(userMapper::createModelFromEntity);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<UserEntity> userEntity = userRepo.findByEmail(email);
        return userEntity.map(userMapper::createModelFromEntity);
    }
}
