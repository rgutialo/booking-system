package com.algerage.report.infraestructure.adapter.in.rest;

import com.algerage.report.application.port.in.RandomGeneratorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {

    private final RandomGeneratorPort randomGenerator;

    public ReportController(RandomGeneratorPort randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Reports. Random result: " + randomGenerator.generateRandomNumber());
    }
}
