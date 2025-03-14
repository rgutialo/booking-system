package com.algerage.search.application.service;

import com.algerage.search.application.port.in.RequestBookingUseCase;
import com.algerage.search.application.port.out.BookingProducerPort;
import com.algerage.search.domain.model.BookingMessage;

public class RequestBookingService implements RequestBookingUseCase {
    private final BookingProducerPort bookingProducerPort;

    public RequestBookingService(BookingProducerPort bookingProducerPort) {
        this.bookingProducerPort = bookingProducerPort;
    }

    @Override
    public void requestBooking(BookingMessage bookingMessage) {
        bookingProducerPort.sendBookingRequest(bookingMessage);
    }
}
