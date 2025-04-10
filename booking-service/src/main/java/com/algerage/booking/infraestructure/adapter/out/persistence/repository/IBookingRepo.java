package com.algerage.booking.infraestructure.adapter.out.persistence.repository;

import com.algerage.booking.infraestructure.adapter.out.persistence.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepo extends JpaRepository<BookingEntity, Long> {
}
