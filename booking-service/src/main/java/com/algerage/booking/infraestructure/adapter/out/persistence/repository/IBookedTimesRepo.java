package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BookingEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ClientEntity;
import com.algerage.booking.infraestructure.adapter.out.persistence.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IBookedTimesRepo extends JpaRepository<BookingEntity, Long> {

    List<BookingEntity> findByClientAndServiceAndBookingStartBetween(ClientEntity client, ServiceEntity service, LocalDateTime startDate, LocalDateTime endDate);
}
