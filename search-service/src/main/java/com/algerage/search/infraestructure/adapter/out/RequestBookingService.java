package com.algerage.search.infraestructure.adapter.out;

import com.algerage.search.application.port.in.RequestBookingPort;
import com.algerage.search.application.port.out.BookingProducerPort;
import com.algerage.search.domain.model.BookingMessage;
import com.algerage.search.infraestructure.config.BookingServiceConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class RequestBookingService implements RequestBookingPort {
    private final BookingProducerPort bookingProducerPort;
    private final BookingServiceConfig bookingServiceConfig;
    private final WebClient webClient;

    public RequestBookingService(BookingProducerPort bookingProducerPort, BookingServiceConfig bookingServiceConfig, @Qualifier("bookingClient") WebClient webClient) {
        this.bookingProducerPort = bookingProducerPort;
        this.bookingServiceConfig = bookingServiceConfig;
        this.webClient = webClient;
    }

    @Override
    public void requestBooking(BookingMessage bookingMessage) {
        bookingProducerPort.sendBookingRequest(bookingMessage);
    }

    @Override
    public void requestRealBooking(BookingMessage bookingMessage) {
        final String bookingServiceURL = bookingServiceConfig.getUrl();
        log.info("Token URL: {}", bookingServiceURL);
        Mono<String> bookingMessageMono = webClient.post()
                .uri("/booking/request")
                .bodyValue(bookingMessage)
                .retrieve()
                .bodyToMono(String.class);
        log.info("Executing request to booking service: {}", bookingMessageMono.block());
    }
}


