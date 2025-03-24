package com.algerage.payment.infraestructure.adapter.in.messaging;

import com.algerage.payment.application.port.in.PaymentConsumerPort;
import com.algerage.payment.domain.model.BookingMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaConsumerPaymentAdapter implements PaymentConsumerPort {
    @Override
    @KafkaListener(id = "paymentConsumer", topics = "payment")
    public void consumePaymentRequest(BookingMessage message) {
        log.info("Payment service consuming: {}", message);
    }
}
