package com.algerage.booking.domain.model;

public record BookingMessage(String clientId, String date, String time, String details) {}
