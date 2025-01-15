package com.algerage.auth.infraestructure.config;

import com.algerage.auth.application.port.in.RandomGeneratorPort;
import com.algerage.auth.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthenticationConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
