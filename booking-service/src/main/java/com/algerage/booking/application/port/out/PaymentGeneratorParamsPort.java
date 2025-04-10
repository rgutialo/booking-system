package com.algerage.booking.application.port.out;

import com.algerage.booking.domain.model.PaymentDetails;

public interface PaymentGeneratorParamsPort {

    PaymentDetails generatePaymentDetails(final String BookingMessage);
}
