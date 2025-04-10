package com.algerage.booking.infraestructure.adapter.in.mappers;

import com.algerage.booking.domain.model.BookingAvailableSlot;
import com.algerage.booking.infraestructure.adapter.out.rest.dto.BookingAvailableSlotResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface BookingAvailableSlotResponseMapper {

    @Mapping(target = "serviceId", expression = "java(bookingAvailableSlot.getService() != null ? String.valueOf(bookingAvailableSlot.getService().getServiceId()) : null)")
    @Mapping(source = "startTime", target = "date", qualifiedByName = "localDateTimeToDateString")
    @Mapping(source = "startTime", target = "startTime", qualifiedByName = "localDateTimeToTimeString")
    @Mapping(source = "endTime", target = "endTime", qualifiedByName = "localDateTimeToTimeString")
    @Mapping(target = "price", expression = "java(bookingAvailableSlot.getService() != null ? bookingAvailableSlot.getService().getPrice() : null)")
    BookingAvailableSlotResponse createResponseFromModel(final BookingAvailableSlot bookingAvailableSlot);

    @Named("localDateTimeToDateString")
    static String localDateTimeToDateString(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : null;
    }

    @Named("localDateTimeToTimeString")
    static String localDateTimeToTimeString(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(DateTimeFormatter.ofPattern("HH:mm")) : null;
    }
}
