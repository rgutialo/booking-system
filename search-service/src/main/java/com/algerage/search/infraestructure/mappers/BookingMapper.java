package com.algerage.search.infraestructure.mappers;

import com.algerage.search.domain.model.BookingMessage;
import com.algerage.search.infraestructure.adapter.in.dto.BookingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMessage createModelFromRequest(BookingRequest orderRequest);
}
