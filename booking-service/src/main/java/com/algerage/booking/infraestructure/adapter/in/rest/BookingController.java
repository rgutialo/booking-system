package com.algerage.booking.infraestructure.adapter.in.rest;

import com.algerage.booking.application.port.in.RandomGeneratorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    private final RandomGeneratorPort randomGenerator;

    public BookingController(RandomGeneratorPort randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Booking. Random result: " + randomGenerator.generateRandomNumber());
    }
}
