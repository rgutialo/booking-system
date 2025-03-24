package com.algerage.booking.infraestructure.adapter.out.messaging;

import com.algerage.booking.application.port.out.BookingAckProducerPort;
import com.algerage.booking.domain.model.BookingMessageAck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class KafkaBookingAckProducerAdapter implements BookingAckProducerPort {

    private final KafkaTemplate<String, BookingMessageAck> kafkaBookingAckTemplate;
    private static final String TOPIC = "bookingAck";

    @Override
    public void sendBookingAck(BookingMessageAck bookingAck) {
        kafkaBookingAckTemplate.send(TOPIC, bookingAck);
        log.info("Message produced: {}", bookingAck);
    }
}
