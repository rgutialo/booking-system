package com.algerage.payment.infraestructure.adapter.in.rest;

import com.algerage.payment.application.port.in.RandomGeneratorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    private final RandomGeneratorPort randomGenerator;

    public PaymentController(RandomGeneratorPort randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Notification. Random result: " + randomGenerator.generateRandomNumber());
    }
}
