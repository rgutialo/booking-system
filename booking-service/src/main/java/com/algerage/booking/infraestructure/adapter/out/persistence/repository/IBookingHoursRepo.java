package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BusinessHoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingHoursRepo extends JpaRepository<BusinessHoursEntity, Long> {

}
