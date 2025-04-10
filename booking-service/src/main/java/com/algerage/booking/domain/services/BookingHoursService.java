package com.algerage.booking.domain.services;

import com.algerage.booking.domain.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingHoursService {

    boolean isSlotBooked(LocalDateTime slotInit, LocalDateTime slotEnd, List<Booking> bookings);
}
