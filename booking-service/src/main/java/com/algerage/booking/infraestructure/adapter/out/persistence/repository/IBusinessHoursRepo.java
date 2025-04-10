package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BusinessHoursEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBusinessHoursRepo extends JpaRepository<BusinessHoursEntity, Long> {
    Optional<BusinessHoursEntity> findByServiceAndWeekday(ServiceEntity service, String weekday);
}
