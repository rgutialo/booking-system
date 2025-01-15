package com.algerage.auth.infraestructure.adapter.in.rest;

import com.algerage.auth.application.port.in.RandomGeneratorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {

    private final RandomGeneratorPort randomGenerator;

    public AuthenticationController(RandomGeneratorPort randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Authentication. Random result: " + randomGenerator.generateRandomNumber());
    }
}
