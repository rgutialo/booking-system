package com.algerage.payment.application.port.in;

import com.algerage.payment.domain.model.BookingMessage;

public interface PaymentConsumerPort {

    void consumePaymentRequest(final BookingMessage message);
}
