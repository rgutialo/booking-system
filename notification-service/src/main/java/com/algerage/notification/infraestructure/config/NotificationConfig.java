package com.algerage.notification.infraestructure.config;

import com.algerage.notification.application.port.in.RandomGeneratorPort;
import com.algerage.notification.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
