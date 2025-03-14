package com.algerage.booking.infraestructure.adapter.in.rest;

import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.domain.model.Booking;
import com.algerage.booking.infraestructure.adapter.in.dto.BookingRequest;
import com.algerage.booking.infraestructure.adapter.in.mappers.BookingMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    private final RandomGeneratorPort randomGenerator;
    private final BookingMapper bookingMapper;

    public BookingController(RandomGeneratorPort randomGenerator, BookingMapper bookingMapper) {
        this.randomGenerator = randomGenerator;
        this.bookingMapper = bookingMapper;
    }

    @GetMapping
    @PreAuthorize("hasRole('user')")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Booking. Random result: " + randomGenerator.generateRandomNumber());
    }
}
