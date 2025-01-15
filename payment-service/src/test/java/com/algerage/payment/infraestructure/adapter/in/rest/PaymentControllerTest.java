package com.algerage.payment.infraestructure.adapter.in.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.algerage.payment.application.port.in.RandomGeneratorPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

    @InjectMocks
    private PaymentController testObj;

    @Mock
    private RandomGeneratorPort randomGeneratorPortMock;


    @Test
    void test_HelloWorld() {
        when(randomGeneratorPortMock.generateRandomNumber()).thenReturn(1);
        final var result = testObj.sayHello();
        Assertions.assertThat(result.getStatusCode().isSameCodeAs(HttpStatus.OK));
    }
}
