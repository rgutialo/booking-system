package com.algerage.booking.infraestructure.config;

import com.algerage.booking.domain.model.BookingMessage;
import com.algerage.booking.domain.model.BookingMessageAck;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerBookingAckConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    public ProducerFactory<String, BookingMessageAck> bookingAckProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        configProps.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configProps.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        JsonSerializer<BookingMessageAck> jsonSerializer = new JsonSerializer<>();
        jsonSerializer.setAddTypeInfo(false);
        return new DefaultKafkaProducerFactory<>(
                configProps,
                new StringSerializer(),
                jsonSerializer
        );
    }

    @Bean
    public KafkaTemplate<String, BookingMessageAck> kafkaBookingAckTemplate() {
        return new KafkaTemplate<String, BookingMessageAck>(bookingAckProducerFactory());
    }
}
