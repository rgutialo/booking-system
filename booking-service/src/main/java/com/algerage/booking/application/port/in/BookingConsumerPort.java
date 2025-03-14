package com.algerage.booking.application.port.in;

import com.algerage.booking.domain.model.BookingMessage;

public interface BookingConsumerPort {

    void consumeBooking(final BookingMessage message);
}
