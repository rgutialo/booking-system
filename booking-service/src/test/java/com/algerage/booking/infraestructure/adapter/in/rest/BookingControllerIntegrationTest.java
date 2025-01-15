package com.algerage.booking.infraestructure.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.algerage.booking.application.port.in.RandomGeneratorPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(
        controllers = {
                BookingController.class,
                RandomGeneratorPort.class
        })
public class BookingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RandomGeneratorPort randomGeneratorPort;

    @Test
    void testHelloWorld() throws Exception {
        Mockito.when(randomGeneratorPort.generateRandomNumber()).thenReturn(1);
        mockMvc.perform(get("/booking").param("client", "testClient"))
                .andExpect(status().isOk());
    }
}
