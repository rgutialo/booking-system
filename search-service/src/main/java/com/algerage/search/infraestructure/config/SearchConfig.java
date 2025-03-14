package com.algerage.search.infraestructure.config;

import com.algerage.search.application.port.in.RandomGeneratorPort;
import com.algerage.search.application.port.out.BookingProducerPort;
import com.algerage.search.application.service.RandomGeneratorService;
import com.algerage.search.application.service.RequestBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SearchConfig {

    @Autowired
    BookingProducerPort bookingProducerPort;

    @Bean
    public RandomGeneratorPort randomGeneratorPort() {
        return new RandomGeneratorService();
    }

    @Bean
    public RequestBookingService requestBookingService() {
        return new RequestBookingService(bookingProducerPort);
    }
}
