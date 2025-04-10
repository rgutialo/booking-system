package com.algerage.booking.application.service;

import com.algerage.booking.application.port.in.PaymentCalculationPort;
import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.domain.model.PaymentDetails;

public class PaymentCalculationService implements PaymentCalculationPort {
    @Override
    public PaymentDetails calculatePayment(Booking message) {
        return null;
    }
}
