package com.algerage.booking.domain.model.mapper;

import com.algerage.booking.domain.model.BookingMessage;
import com.algerage.booking.domain.model.PaymentDetails;

public interface BookingMapper {

    PaymentDetails createPaymentDetailsFromBookingMessage(BookingMessage orderRequest);
}
