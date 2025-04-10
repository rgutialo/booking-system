package com.algerage.booking.domain.services.impl;

import com.algerage.booking.domain.model.*;
import com.algerage.booking.domain.services.BookingHoursService;
import com.algerage.booking.domain.services.BookingSlotGenerator;
import com.algerage.booking.domain.services.BusinessHoursService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class BookingSlotGeneratorImpl implements BookingSlotGenerator {
    final BusinessHoursService businessHoursService;
    final BookingHoursService bookingHoursService;

    @Override
    public List<BookingAvailableSlot> calculateAvailableSlots(String whatever) {
        log.info("Calculating available slots for {}", whatever);
        return List.of();
    }

    @Override
    public List<BookingAvailableSlot> calculateAvailableSlots(final Service service, final LocalDate date,
                                                              final BusinessHours businessHours,
                                                              final List<BlockedTimes> blockedTimes,
                                                              final List<Booking> bookedTimes) {
        LocalDateTime businessEndDateTime = date.atTime(businessHours.getEndTime());

        List<BookingAvailableSlot> availableSlots = new ArrayList<>();
        //LocalTime slotStart = businessHours.getStartTime();
        LocalDateTime dateTimeSlotStart = date.atTime(businessHours.getStartTime());
        //LocalTime slotEnd = slotStart.plusMinutes(service.getDuration());
        LocalDateTime dateTimeSlotEnd = dateTimeSlotStart.plusMinutes(service.getDuration());

        while (dateTimeSlotEnd.isBefore(businessEndDateTime) || dateTimeSlotEnd.equals(businessEndDateTime)) {
            // Check if slot is in blocked time
            boolean isBlocked = businessHoursService.isSlotBlocked(dateTimeSlotStart, dateTimeSlotEnd, blockedTimes);
            // Check if slot is already booked
            boolean isBooked = bookingHoursService.isSlotBooked(dateTimeSlotStart, dateTimeSlotEnd, bookedTimes);

            if (!isBlocked && !isBooked) {
                availableSlots.add(BookingAvailableSlot.builder()
                        .service(service)
                        .startTime(dateTimeSlotStart)
                        .endTime(dateTimeSlotEnd)
                        .build()
                );
            }
            dateTimeSlotStart = dateTimeSlotStart.plusMinutes(service.getDuration());
            dateTimeSlotEnd = dateTimeSlotStart.plusMinutes(service.getDuration());
        }
        return availableSlots;
    }
}
