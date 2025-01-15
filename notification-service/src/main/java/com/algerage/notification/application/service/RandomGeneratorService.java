package com.algerage.notification.application.service;


import com.algerage.notification.application.port.in.RandomGeneratorPort;

import java.util.Random;

public class RandomGeneratorService implements RandomGeneratorPort {


    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
