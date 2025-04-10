package com.algerage.booking.application.port.in;

import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.model.PaymentDetails;

public interface PaymentCalculationPort {

    PaymentDetails calculatePayment(final Booking message);
}
