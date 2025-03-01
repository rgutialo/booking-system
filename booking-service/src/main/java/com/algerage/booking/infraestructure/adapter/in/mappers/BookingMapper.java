package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.infraestructure.adapter.in.dto.BookingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    Booking createModelFromRequest(BookingRequest orderRequest);
}
