package com.algerage.search.infraestructure.adapter.in.rest;

import com.algerage.search.application.port.in.RandomGeneratorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    private final RandomGeneratorPort randomGenerator;

    public SearchController(RandomGeneratorPort randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Search. Random result: " + randomGenerator.generateRandomNumber());
    }
}
