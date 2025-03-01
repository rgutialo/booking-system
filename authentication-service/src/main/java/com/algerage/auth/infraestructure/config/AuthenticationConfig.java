package com.algerage.auth.infraestructure.config;

import com.algerage.auth.application.port.in.RandomGeneratorPort;
import com.algerage.auth.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AuthenticationConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
