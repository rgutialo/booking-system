package com.algerage.search.application.port.in;

import com.algerage.search.domain.model.BookingMessage;

public interface RequestBookingUseCase {

    void requestBooking(final BookingMessage bookingMessage);
}
