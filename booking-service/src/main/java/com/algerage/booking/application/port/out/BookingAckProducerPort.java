package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.BookingMessageAck;

public interface BookingAckProducerPort {

    public void sendBookingAck(BookingMessageAck bookingAck);
}
