package com.algerage.report.infraestructure.adapter.in.rest;

import com.algerage.report.application.port.in.RandomGeneratorPort;
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
                ReportController.class,
                RandomGeneratorPort.class
        })
public class ReportControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RandomGeneratorPort randomGeneratorPort;

    @Test
    void testHelloWorld() throws Exception {
        Mockito.when(randomGeneratorPort.generateRandomNumber()).thenReturn(1);
        mockMvc.perform(get("/reports").param("client", "testClient"))
                .andExpect(status().isOk());
    }
}
