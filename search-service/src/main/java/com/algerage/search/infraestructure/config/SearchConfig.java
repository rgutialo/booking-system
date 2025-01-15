package com.algerage.search.infraestructure.config;

import com.algerage.search.application.port.in.RandomGeneratorPort;
import com.algerage.search.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
