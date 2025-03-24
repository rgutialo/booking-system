package com.algerage.search.infraestructure.adapter.out;

import com.algerage.search.application.port.out.BookingProducerPort;
import com.algerage.search.domain.model.BookingMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class BookingProducerAdapter implements BookingProducerPort {

    private final KafkaTemplate<String, BookingMessage> kafkaTemplate;
    private static final String TOPIC = "booking";

    @Override
    public void sendBookingRequest(BookingMessage bookingMessage) {
        kafkaTemplate.send(TOPIC, bookingMessage);
        log.info("Message produced: {}", bookingMessage);


    }
}