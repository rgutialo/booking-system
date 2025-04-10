package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.model.Client;
import com.algerage.booking.domain.model.Service;

import java.time.LocalDate;
import java.util.List;


public interface BookedTimesPort {
    List<Booking> getBookedTimes(final Client client, Service service, LocalDate date);

    interface BusinessHoursPort {
    }
}
