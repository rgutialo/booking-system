package com.algerage.payment.domain.model;

public record BookingMessage(String clientId, String date, String time, String details) {}
