package com.algerage.payment.infraestructure.adapter.in.rest;

import com.algerage.payment.application.port.in.PaymentSignatureGeneratorPort;
import com.algerage.payment.application.port.in.RandomGeneratorPort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentController {

    private final RandomGeneratorPort randomGenerator;
    private final PaymentSignatureGeneratorPort paymentSignatureGenerator;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Payments. Random result: " + randomGenerator.generateRandomNumber());
    }

    @GetMapping("/signature")
    public ResponseEntity<String> generateSignature() throws Exception {
        return ResponseEntity.ok("Hello World from Payments. Random result: " + paymentSignatureGenerator.generateSignature());
    }
}
