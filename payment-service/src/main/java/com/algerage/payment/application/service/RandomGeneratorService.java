package com.algerage.payment.application.service;



import com.algerage.payment.application.port.in.RandomGeneratorPort;

import java.util.Random;

public class RandomGeneratorService implements RandomGeneratorPort {


    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
