package com.algerage.report.infraestructure.adapter.in.rest;

import com.algerage.report.application.port.in.RandomGeneratorPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReportControllerTest {

    @InjectMocks
    private ReportController testObj;

    @Mock
    private RandomGeneratorPort randomGeneratorPortMock;


    @Test
    void test_HelloWorld() {
        when(randomGeneratorPortMock.generateRandomNumber()).thenReturn(1);
        final var result = testObj.sayHello();
        Assertions.assertThat(result.getStatusCode().isSameCodeAs(HttpStatus.OK));
    }
}
