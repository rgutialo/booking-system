package com.algerage.payment.application.service;

import com.algerage.payment.application.port.in.PaymentRequestGeneratorPort;
import com.algerage.payment.domain.model.PaymentRequest;
import com.algerage.payment.domain.model.PaymentRequestResult;

public class PaymentRequestGeneratorService implements PaymentRequestGeneratorPort {

    @Override
    public PaymentRequestResult requestPayment(PaymentRequest paymentRequest) {
        return null;
    }
}
