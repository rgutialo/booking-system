package com.algerage.booking.domain.services;

import com.algerage.booking.domain.model.*;

import java.time.LocalDate;
import java.util.List;

public interface BookingSlotGenerator {

    List<BookingAvailableSlot> calculateAvailableSlots(final String whatever);
    List<BookingAvailableSlot> calculateAvailableSlots(final Service service, final LocalDate date, final BusinessHours businessHours,
                                                       final List<BlockedTimes> blockedTimes, final List<Booking> bookedTimes);
}
