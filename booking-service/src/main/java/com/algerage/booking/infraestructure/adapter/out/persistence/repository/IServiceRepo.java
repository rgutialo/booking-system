package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceRepo extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByClient(final ClientEntity clientEntity);

}
