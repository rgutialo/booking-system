package com.algerage.report.application.service;

import com.algerage.report.application.port.in.RandomGeneratorPort;
import lombok.AllArgsConstructor;

import java.util.Random;

public class RandomGeneratorService implements RandomGeneratorPort {


    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
