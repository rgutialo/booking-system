package com.algerage.booking.infraestructure.adapter.in.messaging;

import com.algerage.booking.application.port.in.BookingConsumerPort;
import com.algerage.booking.domain.model.BookingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookingConsumerAdapter implements BookingConsumerPort {

    @Override
    @KafkaListener(id = "bookingConsumer", topics = "booking")
    public void consumeBooking(final BookingMessage message) {
        log.info("Message consumed: {}", message);
        //System.out.println("Message consumed: " + message);
    }
}
