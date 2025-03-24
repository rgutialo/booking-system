package com.algerage.payment.domain.model;

public record PaymentRequestResult (String merchantParameters, String merchantSignature) {
}
