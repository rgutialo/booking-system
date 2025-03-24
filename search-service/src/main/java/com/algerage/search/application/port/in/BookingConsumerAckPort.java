package com.algerage.search.application.port.in;

import com.algerage.search.domain.model.BookingMessageAck;

public interface BookingConsumerAckPort {

    void consumeBookingAck(final BookingMessageAck bookingMessageAck);
}
