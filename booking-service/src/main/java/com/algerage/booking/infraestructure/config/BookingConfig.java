package com.algerage.booking.infraestructure.config;

import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
