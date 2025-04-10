package com.algerage.booking.domain.services.impl;

import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.services.BookingHoursService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class BookingHoursServiceImpl implements BookingHoursService {
    @Override
    public boolean isSlotBooked(LocalDateTime slotInit, LocalDateTime slotEnd, List<Booking> bookings) {
        Optional<Booking> foundBlock = bookings.stream().filter(booking -> slotInit.equals(booking.getBookingStart())
                && slotEnd.equals(booking.getBookingEnd()) && booking.getBookingStatus().getBookingStatusId() == 2).findAny();

        return foundBlock.isPresent();
    }
}
