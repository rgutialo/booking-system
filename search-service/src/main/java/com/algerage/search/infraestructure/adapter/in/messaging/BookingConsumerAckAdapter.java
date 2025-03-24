package com.algerage.search.infraestructure.adapter.in.messaging;

import com.algerage.search.domain.model.BookingMessageAck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.algerage.search.application.port.in.BookingConsumerAckPort;

@Component
@Slf4j
@AllArgsConstructor
public class BookingConsumerAckAdapter implements BookingConsumerAckPort {

    @Override
    @KafkaListener(id = "bookingAckConsumer", topics = "bookingAck")
    public void consumeBookingAck(BookingMessageAck bookingMessageAck) {
        log.info("Consuming bookingAck message: {}", bookingMessageAck);
    }
}
