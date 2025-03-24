package com.algerage.payment.infraestructure.adapter.out.redsys;

import com.algerage.payment.application.port.in.PaymentRequestGeneratorPort;
import com.algerage.payment.application.port.in.PaymentSignatureGeneratorPort;
import com.algerage.payment.domain.model.PaymentRequest;
import com.algerage.payment.domain.model.PaymentRequestResult;
import org.springframework.stereotype.Service;

@Service
public class RedsysPaymentAdapter implements PaymentRequestGeneratorPort {

    @Override
    public PaymentRequestResult requestPayment(PaymentRequest paymentRequest) {
        return null;
    }
}
