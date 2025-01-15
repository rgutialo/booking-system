package com.algerage.booking.application.service;

import com.algerage.booking.application.port.in.RandomGeneratorPort;

import java.util.Random;

public class RandomGeneratorService implements RandomGeneratorPort {


    @Override
    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt();
    }
}
