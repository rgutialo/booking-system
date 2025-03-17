package com.algerage.auth.infraestructure.adapter.in.rest;

import com.algerage.auth.application.port.in.RandomGeneratorPort;
import com.algerage.auth.infraestructure.config.KeycloakConfigProperties;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = {
                AuthenticationController.class,
                RandomGeneratorPort.class
        })
public class AuthenticationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RandomGeneratorPort randomGeneratorPort;

    @MockitoBean
    private RestTemplate restTemplate;

    @MockitoBean
    private KeycloakConfigProperties keycloakConfigProperties;

    @Test
    void testHelloWorld() throws Exception {
        Mockito.when(randomGeneratorPort.generateRandomNumber()).thenReturn(1);
        mockMvc.perform(get("/authentication").param("client", "testClient"))
                .andExpect(status().isOk());
    }
}
