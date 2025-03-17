package com.algerage.search.infraestructure.adapter.in.rest;

import com.algerage.search.application.port.in.RandomGeneratorPort;
import com.algerage.search.application.service.RequestBookingService;
import com.algerage.search.config.NoSecurityConfig;
import com.algerage.search.infraestructure.mappers.BookingMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(
        controllers = {
                SearchController.class,
                RandomGeneratorPort.class
        })
@Import(NoSecurityConfig.class)
public class SearchControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RandomGeneratorPort randomGeneratorPort;

    @MockitoBean
    private BookingMapper bookingMapper;

    @MockitoBean
    private RequestBookingService requestBookingService;

    @Test
    void testHelloWorld() throws Exception {
        Mockito.when(randomGeneratorPort.generateRandomNumber()).thenReturn(1);
        mockMvc.perform(get("/search").param("client", "testClient"))
                .andExpect(status().isOk());
    }
}
