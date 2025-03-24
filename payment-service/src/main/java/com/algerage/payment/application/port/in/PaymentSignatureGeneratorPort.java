package com.algerage.payment.application.port.in;

public interface PaymentSignatureGeneratorPort {

    public String generateSignature()  throws Exception;
}
