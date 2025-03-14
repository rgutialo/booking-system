package com.algerage.search.application.port.out;

import com.algerage.search.domain.model.BookingMessage;

public interface BookingProducerPort {
    void sendBookingRequest(BookingMessage bookingMessage);
}
