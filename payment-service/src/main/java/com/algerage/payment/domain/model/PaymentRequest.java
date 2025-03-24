package com.algerage.payment.domain.model;

public record PaymentRequest (String amount, String currencyCode, String merchantURL, String orderId, String urlOK, String urlKO) {
}
