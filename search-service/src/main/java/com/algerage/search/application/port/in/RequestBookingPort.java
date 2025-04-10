package com.algerage.search.application.port.in;

import com.algerage.search.domain.model.BookingMessage;

public interface RequestBookingPort {

    void requestBooking(final BookingMessage bookingMessage);

    void requestRealBooking(final BookingMessage bookingMessage);
}
