package com.algerage.booking.domain.model.mapper.impl;

import com.algerage.booking.domain.model.BookingMessage;
import com.algerage.booking.domain.model.PaymentDetails;
import com.algerage.booking.domain.model.mapper.BookingMapper;

public class BookingMapperImpl implements BookingMapper {
    @Override
    public PaymentDetails createPaymentDetailsFromBookingMessage(BookingMessage message) {
        return new PaymentDetails(message.clientId(),
                "Name",
                "Surname",
                "Street",
                "ZipCode",
                "City",
                "Country");
    }
}