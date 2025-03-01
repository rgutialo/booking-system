package com.algerage.auth.infraestructure.adapter.in.rest;

import com.algerage.auth.application.port.in.RandomGeneratorPort;
import com.algerage.auth.infraestructure.adapter.in.rest.dto.v1.LoginRequest;
import com.algerage.auth.infraestructure.config.KeycloakConfigProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/authentication")
@AllArgsConstructor
public class AuthenticationController {

    private final RandomGeneratorPort randomGenerator;

    private final RestTemplate restTemplate;
    private final KeycloakConfigProperties keycloakProperties;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World from Authentication. Random result: " + randomGenerator.generateRandomNumber());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String tokenUrl = keycloakProperties.getAuthServerUrl() +
                "/realms/" + keycloakProperties.getRealm() +
                "/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", keycloakProperties.getClientId());
        body.add("client_secret", keycloakProperties.getClientSecret());
        body.add("grant_type", "password");
        body.add("username", loginRequest.username());
        body.add("password", loginRequest.password());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, request, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}
