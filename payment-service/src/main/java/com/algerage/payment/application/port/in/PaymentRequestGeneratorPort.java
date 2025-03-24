package com.algerage.payment.application.port.in;

import com.algerage.payment.domain.model.PaymentRequest;
import com.algerage.payment.domain.model.PaymentRequestResult;

public interface PaymentRequestGeneratorPort {

    public PaymentRequestResult requestPayment(final PaymentRequest paymentRequest);
}
