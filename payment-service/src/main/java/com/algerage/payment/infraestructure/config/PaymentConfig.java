package com.algerage.payment.infraestructure.config;

import com.algerage.payment.application.port.in.RandomGeneratorPort;
import com.algerage.payment.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
