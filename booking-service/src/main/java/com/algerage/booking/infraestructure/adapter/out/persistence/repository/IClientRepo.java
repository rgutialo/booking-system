package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepo extends JpaRepository<ClientEntity, Long> {
}
