package com.algerage.report.infraestructure.config;

import com.algerage.report.application.port.in.RandomGeneratorPort;
import com.algerage.report.application.service.RandomGeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReportConfig {

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }
}
