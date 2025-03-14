package com.algerage.search.infraestructure.adapter.out;

import com.algerage.search.application.port.out.BookingProducerPort;
import com.algerage.search.domain.model.BookingMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingProducerAdapter implements BookingProducerPort {

    private final KafkaTemplate<String, BookingMessage> kafkaTemplate;
    private static final String TOPIC = "booking";

    public BookingProducerAdapter(KafkaTemplate<String, BookingMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendBookingRequest(BookingMessage bookingMessage) {
        kafkaTemplate.send(TOPIC, bookingMessage);

    }
}