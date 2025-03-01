package com.algerage.booking.infraestructure.adapter.in.rest;

import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.infraestructure.adapter.in.mappers.BookingMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = {
                BookingController.class,
                RandomGeneratorPort.class,
                BookingMapper.class
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
