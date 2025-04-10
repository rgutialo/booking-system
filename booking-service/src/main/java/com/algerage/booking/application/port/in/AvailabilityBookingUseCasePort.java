package com.algerage.booking.application.port.in;

import com.algerage.booking.domain.model.BookingAvailableSlot;
import com.algerage.booking.infraestructure.adapter.in.AvailabilityBookingRequest;

import java.util.List;

public interface AvailabilityBookingUseCasePort {

    List<BookingAvailableSlot> bookAvailability(final AvailabilityBookingRequest availabilityBookingRequest) throws Exception;
}
